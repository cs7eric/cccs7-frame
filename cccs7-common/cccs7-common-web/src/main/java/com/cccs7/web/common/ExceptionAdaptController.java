package com.cccs7.web.common;

import com.cccs7.web.bean.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常处理器
 *
 * @author cccs7
 * @date 2023/08/07
 */
//@RestControllerAdvice
public class ExceptionAdaptController {

    @ExceptionHandler({RuntimeException.class})
    public Result handlerRuntimeException(RuntimeException runtimeException) {
        runtimeException.printStackTrace();

        return Result.fail();
    }

    @ExceptionHandler({Exception.class})
    public Result handlerException(Exception exception) {
        exception.printStackTrace();
        StackTraceElement[] stackTrace = exception.getStackTrace();
        System.out.println("---------" + stackTrace.toString());

        return Result.fail();
    }
}
