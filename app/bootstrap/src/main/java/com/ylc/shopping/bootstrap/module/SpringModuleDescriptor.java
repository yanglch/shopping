/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.ylc.shopping.bootstrap.module;

import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;

import java.lang.module.ModuleReference;
import java.util.Map;

/**
 *
 * @author ylc
 * @version $Id: SpringModuleDescriptor.java, v 0.1 2019年01月27日 21:55 ylc Exp $
 */
public interface SpringModuleDescriptor {

    /**
     * 获取模块引用
     * @return
     */
    ModuleReference getModuleReference();

    /**
     * 获取spring上下文
     * @return
     */
    ApplicationContext getApplicationContext();

    /**
     * 设置spring上下文
     * @param context
     */
    void setApplicationContext(ApplicationContext context);

    /**
     * 获取spring root上下文
     * @return
     */
    ApplicationContext getRootApplicationContext();

    /**
     * 获取spring配置文件
     * @return
     */
    Map<String, Resource> getSpringResources();

    /**
     * 获取此模块的部署结束时间
     *
     * @return elapsed time
     */
    long getDeploymentEndTime();

    /**
     * 获取此模块的部署开始时间
     *
     * @return 开始时间
     */
    long getDeploymentStartTime();

    /**
     * 部署前钩子
     */
    void deployBefore(ApplicationContext context);

    /**
     * 部署后钩子
     */
    void deployAfter(ApplicationContext context);
}