/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.ylc.shoppingmanage.biz.shared.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ylc
 * @version $Id: ProductVo.java, v 0.1 2018年08月11日 15:38 ylc Exp $
 */
public class ProductVo implements Serializable{

    /** id **/
    private Long       id;

    /** 商品名称 **/
    private String     name;

    /** 商品价格 **/
    private BigDecimal price;

    /** 商品数量 **/
    private Integer    count;

    /** 商品类型 **/
    private List<Long> typeIdList;

    /** 商品状态 **/
    private String     status;

    /** 创建时间 **/
    private Date gmtCreate;

    /** 修改时间 **/
    private Date        gmtUpdate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Long> getTypeIdList() {
        return typeIdList;
    }

    public void setTypeIdList(List<Long> typeIdList) {
        this.typeIdList = typeIdList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(Date gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }
}