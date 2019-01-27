/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.ylc.shopping.bootstrap.module;

import com.ylc.shopping.bootstrap.enums.ConfigurationAttributeEnum;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.lang.module.ModuleReference;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ylc
 * @version $Id: DefaultSpringModuleDescriptor.java, v 0.1 2019年01月27日 22:06 ylc Exp $
 */
public class DefaultSpringModuleDescriptor implements SpringModuleDescriptor {

    private ModuleReference moduleReference;

    private ApplicationContext applicationContext;

    private ApplicationContext rootApplicationContext;

    private Map<String, Resource> springResources = new LinkedHashMap<>();

    private long startTime;

    private long endTime;

    public DefaultSpringModuleDescriptor(ModuleReference moduleReference, ApplicationContext rootApplicationContext) {
        this.moduleReference = moduleReference;
        this.rootApplicationContext = rootApplicationContext;
    }

    @Override
    public ModuleReference getModuleReference() {
        return moduleReference;
    }

    @Override
    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext context) {
        this.applicationContext = context;
    }

    @Override
    public ApplicationContext getRootApplicationContext() {
        return rootApplicationContext;
    }

    @Override
    public Map<String, Resource> getSpringResources() {
        springResources.clear();
        URI uri = moduleReference.location().get();
        var file = new File(uri.getPath(), ConfigurationAttributeEnum.SPRING_XML_LOCALTION.getName());
        if (!file.exists()) {
            return springResources;
        }
        List<File> files = new ArrayList<>();
        listFiles(files, file, ".xml");
        for (var f : files) {
            springResources.put(f.getAbsolutePath(), new FileSystemResource(f));
        }
        return springResources;
    }

    @Override
    public long getDeploymentEndTime() {
        return endTime;
    }

    @Override
    public long getDeploymentStartTime() {
        return startTime;
    }

    @Override
    public void deployBefore(ApplicationContext context) {
        this.startTime = System.currentTimeMillis();
    }

    @Override
    public void deployAfter(ApplicationContext context) {
        this.endTime = System.currentTimeMillis();
    }

    private void listFiles(List<File> subFiles, File parent, String suffix) {
        File[] files = parent.listFiles();
        if (files == null || files.length == 0) {
            return;
        }
        for (File f : files) {
            if (f.isFile() && f.getName().endsWith(suffix)) {
                subFiles.add(f);
            } else if (f.isDirectory()) {
                listFiles(subFiles, f, suffix);
            }
        }
    }
}