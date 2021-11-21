package com.liubin.common.exception;

import com.liubin.common.utils.JSONResult;
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
    public JSONResult handlerMaxUploadFile(MaxUploadSizeExceededException ex) {
        return JSONResult.errorMsg("文件上传大小不能超过500k，请压缩图片或者降低图片质量再上传！");
    }
}
