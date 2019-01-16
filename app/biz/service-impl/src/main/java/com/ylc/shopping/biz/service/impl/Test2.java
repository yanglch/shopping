/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.ylc.shopping.biz.service.impl;

import com.ylc.shoppingmanage.biz.shared.manage.ProductManage;

import java.io.IOException;
import java.util.ServiceLoader;

/**
 *
 * @author ylc
 * @version $Id: Test2.java, v 0.1 2018年10月13日 17:00 ylc Exp $
 */
public class Test2 {
    public static void main(String[] args) throws IOException {
        Test2.class.getModule().addUses(ProductManage.class);
        ServiceLoader<ProductManage> load = ServiceLoader.load(ProductManage.class);
        load.stream().forEach(System.out::println);
        load.stream().forEach(System.out::println);
        load.stream().forEach(System.out::println);
        ServiceLoader<ProductManage> load2 = ServiceLoader.load(ProductManage.class);
        load2.stream().forEach(System.err::println);
        load2.stream().forEach(System.err::println);
        load2.stream().forEach(System.err::println);
        System.err.println(load2.findFirst().get().getName());
    }
}