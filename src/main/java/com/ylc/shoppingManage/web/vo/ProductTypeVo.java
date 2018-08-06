/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.ylc.shoppingManage.web.vo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.ylc.shoppingManage.entity.Product;
import com.ylc.shoppingManage.web.form.ProductForm;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ylc
 * @version $Id: ProductTypeVo.java, v 0.1 2018年08月06日 23:59 ylc Exp $
 */
public class ProductTypeVo implements Serializable{

    private static final long serialVersionUID = 1L;

    /** id **/
    private Long                id;

    /** 类型名称 **/
    private String              name;

    /** 上级类型 **/
    private Long                parent;

    /** 创建时间 **/
    private Date                gmtCreate;

    /** 修改时间 **/
    private Date                gmtUpdate;

    /** 关联商品 **/
    private List<ProductForm>   productForm;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
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

    public List<ProductForm> getProductForm() {
        return productForm;
    }

    public void setProductForm(List<ProductForm> productForm) {
        this.productForm = productForm;
    }
}