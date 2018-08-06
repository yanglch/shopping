/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.ylc.shoppingManage.web.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

/**
 * ��ҳ��ѯ��ҳ����Ϣ����
 *
 * @author jiaying.ye
 * @version $Id: Pagination.java, v 0.1 2016��4��5�� ����2:58:53 jiaying.ye Exp $
 */
public class Pagination implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -5709429585380828858L;

    /** ÿҳ�Ĵ�С */
    private int               pageSize;

    /** ҳ�� */
    private int               current;

    /** ���� */
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
