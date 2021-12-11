package com.liubin.common.exception;

import com.liubin.common.api.CommonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

/**
 * @author liubin
 */
@RestControllerAdvice
public class CustomExceptionHandler {

    /**
     * 上传文件超过500k，捕获异常：MaxUploadSizeExceededException
     * @param ex
     * @return
     */
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public CommonResult handlerMaxUploadFile(MaxUploadSizeExceededException ex) {
        return CommonResult.failed("文件上传大小不能超过500k，请压缩图片或者降低图片质量再上传！");
    }
}
