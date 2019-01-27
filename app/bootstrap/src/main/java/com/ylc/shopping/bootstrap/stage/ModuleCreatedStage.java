/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.ylc.shopping.bootstrap.stage;

import com.ylc.shopping.bootstrap.ApplicationRuntimeContext;
import com.ylc.shopping.bootstrap.module.DefaultSpringModuleDescriptor;
import com.ylc.shopping.bootstrap.module.SpringModuleDescriptor;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.lang.module.ModuleFinder;
import java.lang.module.ModuleReference;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author ylc
 * @version $Id: ModuleCreatedStage.java, v 0.1 2019年01月27日 21:15 ylc Exp $
 */
public class ModuleCreatedStage extends AbstractProcessStage {

    private final static String PACKAGE_SEPARATOR = ".";

    private final static String MODULE_FILE_LOCATION = "module-info.class";

    private final static String RELATIVE_MODULE_FILE_NAME_CLASS_PATH_LOCATION = "../../classes";

    private final static String FILE_JRT_PROTOCOL = "jrt";

    private final static String FILE_JAR_PROTOCOL = "jar";

    private final static String FILE_JAR_SUFFIX = "!";

    private final static String FILE_PREFIX = "file:/";

    public ModuleCreatedStage(ApplicationRuntimeContext applicationRuntimeContext) {
        super(applicationRuntimeContext);
    }

    @Override
    public void process() throws Exception {
        //获取所有module的路径
        List<Path> allModulePath = getAllModulePath();
        //根据配置从路径中筛选出应用module
        List<ModuleReference> moduleReferences = getApplicationModule(allModulePath.toArray(Path[]::new));
       //封装进 applicationRuntimeContext
        buildModuleDescriptor(moduleReferences);
    }

    protected void buildModuleDescriptor(List<ModuleReference> moduleReferences){
        List<SpringModuleDescriptor> deployModules = applicationRuntimeContext.getDeployModules();
        moduleReferences.forEach(x->{
            deployModules.add(new DefaultSpringModuleDescriptor(x, applicationRuntimeContext.getRootApplicationContext()));
        });
    }

    protected List<ModuleReference> getApplicationModule(Path[] paths){
        String moduleNamePrefix = applicationRuntimeContext.getRootPackageName();
        if(StringUtils.hasText(applicationRuntimeContext.getAppName())){
            moduleNamePrefix += PACKAGE_SEPARATOR + applicationRuntimeContext.getAppName();
        }
        final String finalModuleNamePrefix = moduleNamePrefix;
        return ModuleFinder.of(paths).findAll()
                .stream()
                .filter(x -> x.descriptor().name().startsWith(finalModuleNamePrefix))
                .collect(Collectors.toList());
    }

    protected List<Path> getAllModulePath() throws IOException {
        Enumeration<URL> urls = this.getClass().getClassLoader().getResources(MODULE_FILE_LOCATION);
        List<Path> pathList = new ArrayList<>();
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            String path = url.getPath();
            if (FILE_JRT_PROTOCOL.equals(url.getProtocol())) {
                continue;
            } else if (FILE_JAR_PROTOCOL.equals(url.getProtocol())) {
                path = StringUtils.replace(path.substring(0, path.indexOf(FILE_JAR_SUFFIX)), FILE_PREFIX, "");
                pathList.add(new File(path).toPath());
            } else {
                pathList.add(new File(path).toPath().resolve(RELATIVE_MODULE_FILE_NAME_CLASS_PATH_LOCATION));
            }
        }
        return pathList;
    }

}