/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.ylc.shopping.bootstrap.stage;

import com.ylc.shopping.bootstrap.ApplicationRuntimeContext;
import com.ylc.shopping.bootstrap.loader.DefaultSpringApplicationLoader;
import com.ylc.shopping.bootstrap.loader.SpringApplicationLoader;

/**
 *
 * @author ylc
 * @version $Id: ModuleInstallStage.java, v 0.1 2019年01月27日 23:21 ylc Exp $
 */
public class ModuleInstallStage extends AbstractProcessStage {

    public ModuleInstallStage(ApplicationRuntimeContext applicationRuntimeContext) {
        super(applicationRuntimeContext);
    }

    @Override
    public void process() throws Exception {
        new DefaultSpringApplicationLoader(applicationRuntimeContext).loadSpringApplication();

    }
}