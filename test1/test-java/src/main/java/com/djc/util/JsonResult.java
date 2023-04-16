package com.djc.util;

import java.io.Serializable;

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
        this.message = e.getMessage();
    }

    public JsonResult(Integer code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public JsonResult(Integer code, String message, E data) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
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

    /**
     * 创建一个表示失败响应的实例
     * @param code 状态码
     * @param message 错误消息
     * @return JsonResult 实例
     */
    public static <E> JsonResult<E> error(Integer code, String message) {
        return new JsonResult<>(code, message, null);
    }
}
