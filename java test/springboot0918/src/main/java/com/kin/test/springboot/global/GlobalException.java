/*
package com.kin.test.springboot.global;

*/
/**
 * @program: springboot0918
 * @description: 统一异常处理
 * @author: 黄永健
 * @create: 2019-09-18 14:21
 **//*

import com.kin.test.springboot.exception.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalException {

    private static final Logger logger = LoggerFactory.getLogger(GlobalException.class);
    @ExceptionHandler
    @ResponseBody
    public Result userException(UserException u, HttpServletRequest request , HttpServletResponse response){
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        return Result.error(u.getCode(),u.getMessage());
    }
    @ExceptionHandler
    @ResponseBody
    public Result unKnowException(Exception e){
        return Result.error(504,"服务故障");
    }
    @ExceptionHandler
    @ResponseBody
    public Result unKnowRuntimeException(RuntimeException r){

        return Result.error(505,"服务异常");
    }
    @ExceptionHandler
    @ResponseBody
    public Result methodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request, HttpServletResponse response) {
        FieldError fieldError = e.getBindingResult().getFieldError();
        if (fieldError != null) {
            String field = fieldError.getField();
            String errorMsg = fieldError.getDefaultMessage();

            return Result.error(201, errorMsg);
        }

        return Result.error(201, "参数错误");
    }

}*/
