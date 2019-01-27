/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.ylc.shopping.bootstrap.config;

import com.ylc.shopping.bootstrap.ApplicationRuntimeContext;
import com.ylc.shopping.bootstrap.stage.ModuleCreatedStage;
import com.ylc.shopping.bootstrap.stage.ModuleInstallStage;
import com.ylc.shopping.bootstrap.stage.ModuleProcessStage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author ylc
 * @version $Id: MyModuleAutoConfiguration.java, v 0.1 2019年01月27日 21:36 ylc Exp $
 */
@Configuration
public class ModuleAutoConfiguration {

    @Bean
    public ApplicationRuntimeContext applicationRuntimeContext(ApplicationContext applicationContext){
        return new ApplicationRuntimeContext(applicationContext);
    }

    @Bean
    public ModuleProcessStage moduleCreatedStage(ApplicationRuntimeContext applicationRuntimeContext){
        return new ModuleCreatedStage(applicationRuntimeContext);
    }

    @Bean
    public ModuleProcessStage moduleInstallStage(ApplicationRuntimeContext applicationRuntimeContext){
        return new ModuleInstallStage(applicationRuntimeContext);
    }
}