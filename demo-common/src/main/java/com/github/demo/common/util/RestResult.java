package com.github.demo.common.util;

import lombok.Data;

import java.io.Serializable;

/**
 * 返回数据
 *
 * @author mq
 */
@Data
public class RestResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final int OK = 0;
    private static final String M_OK = "成功";
    private static final int ERROR = 500;
    private static final String M_ERROR = "未知异常，请联系管理员";

    /**
     * 错误代码
     */
    private int errno;

    /**
     * 错误消息
     */
    private String errmsg;

    /**
     * 数据
     */
    private T res;

    public static RestResult<String> ok() {
        return ok(M_OK);
    }

    public static <T> RestResult<T> ok(T data) {
        RestResult<T> restResult = new RestResult<>();
        restResult.setErrmsg("");
        restResult.setErrno(OK);
        restResult.setRes(data);
        return restResult;
    }

    public static RestResult<String> error() {
        return error(M_ERROR);
    }

    public static RestResult<String> error(String msg) {
        return error(ERROR, msg);
    }

    public static RestResult<String> error(int code, String msg) {
        RestResult<String> restResult = new RestResult<>();
        restResult.setErrmsg(msg);
        restResult.setErrno(code);
        restResult.setRes("");
        return restResult;
    }

}
