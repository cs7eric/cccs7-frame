package com.cccs7.web.common;

import com.cccs7.web.bean.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdaptController {

    @ExceptionHandler({RuntimeException.class})
    public Result handlerRuntimeException (RuntimeException runtimeException) {
        runtimeException.printStackTrace();
        return Result.fail();
    }

    @ExceptionHandler({Exception.class})
    public Result handlerException (Exception exception) {
        exception.printStackTrace();
        return Result.fail();
    }
}
