package com.kin.test.springboot.global;

import com.kin.test.springboot.exception.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler
    @ResponseBody
    public Result userException(UserException e){
        logger.warn("userException",e);
        return Result.error(e.getCode(),e.getMessage());
    }

    @ExceptionHandler
    @ResponseBody
    public String unkownRuntimeException(RuntimeException e) {
        logger.warn("unkonw exception", e);
        return "系统出异常,请重试";
    }

    @ExceptionHandler
    @ResponseBody
    public void unKonwException(Exception e) {
        logger.warn("unkonw exception", e);
    }
}
