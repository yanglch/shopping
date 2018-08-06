/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.ylc.shoppingManage.web.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 分页查询的页码信息对象
 *
 * @author jiaying.ye
 * @version $Id: Pagination.java, v 0.1 2016年4月5日 下午2:58:53 jiaying.ye Exp $
 */
public class Pagination implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -5709429585380828858L;

    /** 每页的大小 */
    private int               pageSize;

    /** 页码 */
    private int               current;

    /** 总数 */
    private long              total;

    /**
     * Getter method for property <tt>pageSize</tt>.
     * 
     * @return property value of pageSize
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * Setter method for property <tt>pageSize</tt>.
     * 
     * @param pageSize value to be assigned to property pageSize
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * Getter method for property <tt>current</tt>.
     * 
     * @return property value of current
     */
    public int getCurrent() {
        return current;
    }

    /**
     * Setter method for property <tt>current</tt>.
     * 
     * @param current value to be assigned to property current
     */
    public void setCurrent(int current) {
        this.current = current;
    }

    /**
     * Getter method for property <tt>total</tt>.
     * 
     * @return property value of total
     */
    public long getTotal() {
        return total;
    }

    /**
     * Setter method for property <tt>total</tt>.
     * 
     * @param total value to be assigned to property total
     */
    public void setTotal(long total) {
        this.total = total;
    }

    /** 
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
