/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.ylc.shopping.bootstrap.enums;

/**
 *
 * @author ylc
 * @version $Id: ConfigurationAttributeEnum.java, v 0.1 2019年01月27日 21:27 ylc Exp $
 */
public enum ConfigurationAttributeEnum {

    APPLICATION_NAME("spring.application.name", "应用名称"),
    ROOT_PACKAGE_NAME("spring.root-package-name", "根目录"),
    SPRING_XML_LOCALTION("spring", "spring的xml配置目录");
    private String name;
    private String desc;

    ConfigurationAttributeEnum(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}