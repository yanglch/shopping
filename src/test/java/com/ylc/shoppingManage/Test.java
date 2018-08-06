/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.ylc.shoppingManage;

import com.ylc.shoppingManage.enums.ProductStatusEnum;

import java.math.BigDecimal;

/**
 *
 * @author ylc
 * @version $Id: Test.java, v 0.1 2018年08月06日 22:29 ylc Exp $
 */
public class Test {

    public static void main(String[] args) {
        ProductStatusEnum ss = ProductStatusEnum.getByCode("ON_DOWN");
        System.err.println(ss);
    }
}