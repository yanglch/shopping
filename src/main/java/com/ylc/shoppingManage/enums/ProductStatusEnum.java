/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.ylc.shoppingManage.enums;

/**
 *
 * @author ylc
 * @version $Id: ProductStatusEnum.java, v 0.1 2018年08月07日 0:25 ylc Exp $
 */
public enum ProductStatusEnum {

                /** 上架 **/
                ON_UP("ON_LINE", "上架"),

                /** 下架 **/
                ON_DOWN("ON_DOWN", "下架");



    /** code **/
    private String code;

    /** 描述 **/
    private String desc;

    ProductStatusEnum(String code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public static ProductStatusEnum getByCode(String code){
        for(ProductStatusEnum result : values()){
            if (result.getCode().equals(code)) {
                return result;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}