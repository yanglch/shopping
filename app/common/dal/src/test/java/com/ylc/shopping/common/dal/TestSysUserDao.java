/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.ylc.shopping.common.dal;

import com.ylc.shopping.common.dal.dataobject.SysUserDo;
import com.ylc.shopping.common.dal.mybatis.SysUserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author ylc
 * @version $Id: TestSysUserDao.java, v 0.1 201:38 ylc Exp $
 */
@SpringBootApplication(exclude = WebMvcAutoConfiguration.class)
public class TestSysUserDao {

    @Autowired
    private SysUserDao sysUserDao;

    @Test
    public void getUser(){
        SysUserDo sysUserDo = sysUserDao.selectById(1);
        System.err.println(sysUserDo.getLoginName());
        var a = 1;
        System.err.println(a);
    }

    public static void main(String[] args) {
        new SpringApplication(TestSysUserDao.class).run();
    }

}