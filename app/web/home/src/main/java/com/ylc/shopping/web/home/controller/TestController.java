/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.ylc.shopping.web.home.controller;

import com.ylc.shopping.common.dal.mybatis.SysUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ylc
 * @version $Id: TestController.java, v 0.1 2018年11月10日 19:55 ylc Exp $
 */
@RestController
public class TestController {

    @Autowired(required = false)
    private SysUserDao sysUserDao;

    @RequestMapping("/hello")
    public Object hello(){
        return sysUserDao.selectById(1);
    }
}