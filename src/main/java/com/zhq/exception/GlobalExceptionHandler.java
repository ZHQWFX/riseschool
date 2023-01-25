package com.zhq.exception;

import com.zhq.pojo.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author chenchenchen
 * @create 2023-01-17 11:00
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    //全局处理异常
    @ExceptionHandler(Exception.class)
    public Result error(Exception e){
        e.printStackTrace();
        return Result.fail().message("服务器异常!");
    }
}
