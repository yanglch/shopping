/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.ylc.shopping.bootstrap.stage;

import com.ylc.shopping.bootstrap.ApplicationRuntimeContext;

/**
 *
 * @author ylc
 * @version $Id: AbstractProcessStage.java, v 0.1 2019年01月27日 21:20 ylc Exp $
 */
public abstract class AbstractProcessStage implements ModuleProcessStage {

    protected final ApplicationRuntimeContext applicationRuntimeContext;

    public AbstractProcessStage(ApplicationRuntimeContext applicationRuntimeContext) {
        this.applicationRuntimeContext = applicationRuntimeContext;
    }



}