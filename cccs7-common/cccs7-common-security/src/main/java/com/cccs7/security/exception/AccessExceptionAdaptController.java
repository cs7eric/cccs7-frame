package com.cccs7.security.exception;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <p> 认证与授权异常处理器 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 认证与授权异常处理器
 * @Date 2023/8/7 23:51
 */
@RestControllerAdvice
public class AccessExceptionAdaptController {

    @ExceptionHandler(AccessDeniedException.class)
    public void handleAccessException(AccessDeniedException accessDeniedException) {

        throw accessDeniedException;
    }
}
