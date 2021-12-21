package com.liubin.common.api;

import com.liubin.common.constant.ExceptionConstant;
import lombok.Getter;

/**
 * 枚举了一些常用API操作码
 * @author liubin
 */
@Getter
public enum ResponseCode implements IErrorCode {

    SUCCESS(ExceptionConstant.SUCCESS, "OK"),
    SYSTEM_EXCEPTION(ExceptionConstant.SYSTEM_EXCEPTION, "系统繁忙"),
    SERVICE_EXCEPTION(ExceptionConstant.SERVICE_EXCEPTION, "业务处理异常"),
    ILLEGAL_REQUEST(ExceptionConstant.ILLEGAL_REQUEST, "非法请求"),
    DATA_PERSISTENCE_FAIL(ExceptionConstant.DATA_PERSISTENCE_FAIL, "数据访问失败"),
    LOGIN_TIMEOUT(ExceptionConstant.LOGIN_TIMEOUT, "登录超时"),
    LOGIN_ERROR(ExceptionConstant.LOGIN_FAIL, "登录失败"),
    LOGIN_STOP(ExceptionConstant.LOGIN_STOP, "账号停用"),
    UNAUTHORIZED(ExceptionConstant.UNAUTHORIZED, "没有访问权限"),
    ;

    /**
     * 是否调用成功
     */
    private boolean success;

    private int code;
    private String message;

    private ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public int getCode() {
        return this.code;
    }
}
