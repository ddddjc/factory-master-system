package com.djc.exception;

public enum ResultCode {
    SUCCESS(200, "请求成功"),
    BAD_REQUEST(400, "请求参数有误"),
    UNAUTHORIZED(401, "未经授权访问"),
    FORBIDDEN(403, "无权访问"),
    NOT_FOUND(404, "请求资源不存在"),
    METHOD_NOT_ALLOWED(405, "请求方法不允许"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),
    SERVICE_UNAVAILABLE(503, "服务不可用"),

    // 自定义应用程序状态码
    INVALID_USERNAME_PASSWORD(1001, "用户名或密码错误"),
    USER_NOT_FOUND(1002, "用户不存在"),
    DUPLICATE_USERNAME(1003, "用户名已存在"),
    FAILED_TO_DELETE(1004, "删除失败");

    private final int code;
    private final String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
