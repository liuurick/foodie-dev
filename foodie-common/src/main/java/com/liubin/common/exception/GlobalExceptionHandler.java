package com.liubin.common.exception;

import com.liubin.common.api.CommonResult;
import com.liubin.common.api.IErrorCode;
import com.liubin.common.api.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.sql.SQLException;

/**
 * @author liubin
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 上传文件超过500k，捕获异常：MaxUploadSizeExceededException
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public CommonResult handlerMaxUploadFile(MaxUploadSizeExceededException ex) {
        return CommonResult.failed("文件上传大小不能超过500k，请压缩图片或者降低图片质量再上传！");
    }

}
