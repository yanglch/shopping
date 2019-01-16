/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.ylc.shopping.common.dal.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 *
 * @author ylc
 * @version $Id: DalConfig.java, v 0.1 2018年10月14日 3:23 ylc Exp $
 */
@Configuration
public class DalConfig {

    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/shopping?serverTimezone=UTC&amp;useSSL=true");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
    }

}