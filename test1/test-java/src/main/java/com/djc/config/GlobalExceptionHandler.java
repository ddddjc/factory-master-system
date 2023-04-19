package com.djc.config;

import com.djc.exception.CustomException;
import com.djc.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(CustomException.class)
    public JsonResult<?> handleCustomException(CustomException e) {
        return JsonResult.error(e.getCode(), e.getMessage());
    }
    /**
     * 处理运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    public JsonResult<?> handleException(RuntimeException e) {
        // 这里可以根据实际情况进行处理，例如将异常信息记录到日志中
        e.printStackTrace();
        return JsonResult.error(5001, e.getMessage());
    }
    /**
     * 处理其他未知异常
     */
    @ExceptionHandler(Exception.class)
    public JsonResult<?> handleException(Exception e) {
        // 这里可以根据实际情况进行处理，例如将异常信息记录到日志中
        e.printStackTrace();
        return JsonResult.error(5002, e.getMessage());
    }
}
