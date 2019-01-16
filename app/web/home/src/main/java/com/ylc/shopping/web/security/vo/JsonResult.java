/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.ylc.shopping.web.security.vo;

import java.io.Serializable;
import java.util.Map;

/**
 *  统一返回结果
 * @author ylc
 * @version $Id: JsonResult.java, v 0.1 2018年08月06日 22:03 ylc Exp $
 */
public class JsonResult implements Serializable{

    private String msg;

    private Object data;

    private boolean success;

    private Map<String, Object> expMap;

    public JsonResult(){}

    public JsonResult(boolean success){
        this.success = success;
    }

    public JsonResult(String msg, Object data, boolean success) {
        this.msg = msg;
        this.data = data;
        this.success = success;
    }

    public static JsonResult newJsonResultSuccess(){
        return new JsonResult(true);
    }

    public static JsonResult newJsonResultSuccess(Object data){
        return new JsonResult(null, data, true);
    }

    public static JsonResult jsonResultSuccess(JsonResult jsonResult, Object data, boolean success){
        jsonResult.setData(data);
        jsonResult.setSuccess(success);
        return jsonResult;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Map<String, Object> getExpMap() {
        return expMap;
    }

    public void setExpMap(Map<String, Object> expMap) {
        this.expMap = expMap;
    }
}