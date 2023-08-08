package com.cccs7.user.exception;

import com.cccs7.web.bean.Result;
import com.cccs7.web.bean.ResultCode;
import com.cccs7.web.common.ExceptionAdaptController;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <p> 异常处理器 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 异常处理器
 * @Date 2023/8/8 13:00
 */
@RestControllerAdvice
public class ExceptionAdaptControllerImpl implements ExceptionAdaptController {


    @Override
    @ExceptionHandler(RuntimeException.class)
    public Result handlerRuntimeException(RuntimeException runtimeException) {
        runtimeException.printStackTrace();
        String message = runtimeException.getMessage();
        return Result.fail(ResultCode.ERROR_CODE, message);
    }

    @Override
    @ExceptionHandler(Exception.class)
    public Result handlerException(Exception exception) {
        exception.printStackTrace();
        String message = exception.getMessage();
        return Result.fail(ResultCode.ERROR_CODE, message);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public Result handlerAccessDeniedException(AccessDeniedException accessDeniedException) {
        throw accessDeniedException;
    }
}
