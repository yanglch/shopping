/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.ylc.shopping.web.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ylc
 * @version $Id: TestController.java, v 0.1 2018年11月10日 19:55 ylc Exp $
 */
@RestController
public class TestController {

    @GetMapping("/hello1")
    public String hello(){
        return "home module hello!!";
    }
}