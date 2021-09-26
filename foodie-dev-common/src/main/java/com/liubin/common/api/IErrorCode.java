package com.liubin.common.api;

/**
 * 封装API的错误码
 * @author liubin
 */
public interface IErrorCode {
    long getCode();

    String getMessage();
}
