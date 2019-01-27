/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.ylc.shopping.common.dal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;

/**
 *
 * @author ylc
 * @version $Id: TestSysUserDao.java, v 0.1 201:38 ylc Exp $
 */
@SpringBootApplication(exclude = WebMvcAutoConfiguration.class)
public class SysUserDaoa {

    public static void main(String[] args) {
        new SpringApplication(SysUserDaoa.class).run();
    }
}