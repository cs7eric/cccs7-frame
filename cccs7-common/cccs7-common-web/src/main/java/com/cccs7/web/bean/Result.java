package com.cccs7.web.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private boolean success;
    private Integer code;
    private String message;
    private T data;

    private Result(boolean success, Integer code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> ok() {
        return new Result<>(true, ResultCode.SUCCESS_CODE, ResultMessage.SUCCESS_MESSAGE, null);
    }

    public static <T> Result<T> ok(T data) {
        return new Result<>(true, ResultCode.SUCCESS_CODE, ResultMessage.SUCCESS_MESSAGE, data);
    }

    public static <T> Result<T> ok(Integer resultCode, String resultMessage) {
        return new Result<>(true, resultCode, resultMessage, null);
    }

    public static <T> Result<T> ok(Integer resultCode, String resultMessage, T data) {
        return new Result<>(true, resultCode, resultMessage, data);
    }

    public static <T> Result<T> fail() {
        return new Result<>(false, ResultCode.ERROR_CODE, ResultMessage.ERROR_MESSAGE, null);
    }

    public static <T> Result<T> fail(T data) {
        return new Result<>(false, ResultCode.ERROR_CODE, ResultMessage.ERROR_MESSAGE, data);
    }

    public static <T> Result<T> fail(Integer resultCode, String resultMessage) {
        return new Result<>(false, resultCode, resultMessage, null);
    }

    public static <T> Result<T> fail(Integer resultCode, String resultMessage, T data) {
        return new Result<>(false, resultCode, resultMessage, data);
    }
}
