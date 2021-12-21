package com.liubin.common.api;

/**
 * 封装API的错误码
 * @author liubin
 */
public interface IErrorCode {

    /**
     * 错误码
     * @return
     */
    int getCode();

    /**
     * 信息描述
     * @return
     */
    String getMessage();
}
