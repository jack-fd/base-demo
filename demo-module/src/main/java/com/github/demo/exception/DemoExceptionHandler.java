package com.github.demo.exception;

import com.github.demo.common.excepiton.DemoException;
import com.github.demo.common.util.RestResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理器
 *
 * @author mq
 */
@Slf4j
@RestControllerAdvice
public class DemoExceptionHandler {

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(DemoException.class)
    public RestResult handleRRException(DemoException e) {
        log.error(e.getMessage(), e);
        return RestResult.error(e.getCode(), e.getMsg());
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public RestResult handleDuplicateKeyException(DuplicateKeyException e) {
        log.error(e.getMessage(), e);
        return RestResult.error("数据库中已存在该记录");
    }

    @ExceptionHandler(Exception.class)
    public RestResult handleException(Exception e) {
        log.error(e.getMessage(), e);
        return RestResult.error("系统异常");
    }
}
