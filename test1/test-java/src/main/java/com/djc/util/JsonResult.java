package com.djc.util;

import java.io.Serializable;

/**
 * 响应结果类
 * @param <E> 响应数据的类型
 */
public class JsonResult<E> implements Serializable {
    /** 状态码 */
    private Integer code;

    /** 数据 */
    private E data;

    /** 状态描述信息 */
    private String message;



    public JsonResult() {
        super();
    }

    public JsonResult(Integer code) {
        super();
        this.code = code;
    }

    /** 出现异常时调用 */
    public JsonResult(Throwable e) {
        super();
        // 获取异常对象中的异常信息
        this.message = e.getMessage();
    }

    public JsonResult(Integer code, E data) {
        super();
        this.code = code;
        this.data = data;
    }

    public JsonResult(Integer code, String message, E tata) {
        this.code = code;
        this.message = message;
        this.data = tata;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
