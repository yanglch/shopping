/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.ylc.shopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 *
 * @author ylc
 * @version $Id: Starter.java, v 0.1 201808
 */
@SpringBootApplication
public class Starter extends SpringBootServletInitializer {

    public static void main(String[] args){
        SpringApplication.run(Starter.class);
    }

}