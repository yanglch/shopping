/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.ylc.shopping.bootstrap;

import com.ylc.shopping.bootstrap.enums.ConfigurationAttributeEnum;
import com.ylc.shopping.bootstrap.module.SpringModuleDescriptor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.List;
import java.util.Vector;

/**
 *
 * @author ylc
 * @version $Id: ApplicationRuntimeContext.java, v 0.1 2019年01月27日 20:59 ylc Exp $
 */
public class ApplicationRuntimeContext {

    /** 应用名称 **/
    private String appName;

    /** 模块的根package **/
    private String rootPackageName;

    /** 所有部署模块 **/
    private final List<SpringModuleDescriptor> deployModules = new Vector<>();

    /** 部署失败的模块 **/
    private final List<SpringModuleDescriptor> deployFailedModules = new Vector<>();

    /** 部署成的模块 **/
    private final List<SpringModuleDescriptor> deploySuccessModules = new Vector<>();

    /** 根上下文 **/
    private ApplicationContext rootApplicationContext;

    /** 构建开始时间 **/
    private long startTime;

    /** 构建结束时间 **/
    private long endTime;

    public ApplicationRuntimeContext(ApplicationContext rootApplicationContext) {
        this.rootApplicationContext = rootApplicationContext;
        ConfigurableEnvironment environment = ((AbstractApplicationContext) rootApplicationContext).getEnvironment();
        this.appName = environment.getProperty(ConfigurationAttributeEnum.APPLICATION_NAME.getName());
        this.rootPackageName = environment.getProperty(ConfigurationAttributeEnum.ROOT_PACKAGE_NAME.getName());
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public void setRootPackageName(String rootPackageName) {
        this.rootPackageName = rootPackageName;
    }

    public String getAppName() {
        return appName;
    }

    public String getRootPackageName() {
        return rootPackageName;
    }

    public List<SpringModuleDescriptor> getDeployModules() {
        return deployModules;
    }

    public List<SpringModuleDescriptor> getDeployFailedModules() {
        return deployFailedModules;
    }

    public List<SpringModuleDescriptor> getDeploySuccessModules() {
        return deploySuccessModules;
    }

    public ApplicationContext getRootApplicationContext() {
        return rootApplicationContext;
    }

}