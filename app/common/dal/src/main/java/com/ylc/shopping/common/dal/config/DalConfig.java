/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.ylc.shopping.common.dal.config;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 *
 * @author ylc
 * @version $Id: DalConfig.java, v 0.1c Exp $
 */
@Configuration
@MapperScan("com.ylc.shopping.common.dal.mybatis")
public class DalConfig {



}