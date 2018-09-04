/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.ylc.shopping.biz.service.impl;

import com.ylc.shoppingmanage.biz.shared.manage.ProductManage;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 *
 * @author ylc
 * @version $Id: Test.java, v 0.1 2018年08月12日 7:23 ylc Exp $
 */
public class Test {


    public static void main(String[] args) {
        ProductManage productManage;
        ServiceLoader<ProductManage> loader = ServiceLoader.load(ProductManage.class);
        Iterator<ProductManage> iterator = loader.iterator();
        if(iterator.hasNext()) {
            productManage = iterator.next();
        }

    }
}