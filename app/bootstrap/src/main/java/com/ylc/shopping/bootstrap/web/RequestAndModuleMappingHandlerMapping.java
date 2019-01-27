/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.ylc.shopping.bootstrap.web;

import org.springframework.boot.actuate.endpoint.web.annotation.ExposableControllerEndpoint;
import org.springframework.context.ApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;
import java.util.Map;

/**
 *
 * @author ylc
 * @version $Id: RequestAndModuleMappingHandlerMapping.java, v 0.1 2019年01月27日 19:55 ylc Exp $
 */
public class RequestAndModuleMappingHandlerMapping extends RequestMappingHandlerMapping{

    private String moduleName;

    @Override
    protected void initHandlerMethods() {
        setDetectHandlerMethodsInAncestorContexts(true);
        super.initHandlerMethods();
        ApplicationContext parent = obtainApplicationContext().getParent();
        if(parent != null){
            RequestMappingHandlerMapping handlerMapping = parent.getBean("requestMappingHandlerMapping",
                    RequestMappingHandlerMapping.class);
            Map<RequestMappingInfo, HandlerMethod> handlerMethods = handlerMapping.getHandlerMethods();
        }
    }

}