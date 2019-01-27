/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.ylc.shopping.bootstrap.loader;

import com.ylc.shopping.bootstrap.ApplicationRuntimeContext;
import com.ylc.shopping.bootstrap.module.SpringModuleDescriptor;

import java.util.List;

/**
 *
 * @author ylc
 * @version $Id: DefaultSpringApplicationLoader.java, v 0.1 2019年01月28日 0:22 ylc Exp $
 */
public class DefaultSpringApplicationLoader implements SpringApplicationLoader {

    private ApplicationRuntimeContext applicationRuntimeContext;

    public DefaultSpringApplicationLoader(ApplicationRuntimeContext applicationRuntimeContext) {
        this.applicationRuntimeContext = applicationRuntimeContext;
    }

    @Override
    public void loadSpringApplication() {
        List<SpringModuleDescriptor> deployModules = applicationRuntimeContext.getDeployModules();
        deployModules.forEach(deployModule -> {
            SpringModuleLoader moduleLoader = new DefaultSpringModuleLoader(deployModule);
            moduleLoader.loadSpringModule();
        });
    }
}