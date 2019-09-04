package dev.application.global;


import dev.application.exception.UserException;
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
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler
    @ResponseBody
    public ResultBean userException(UserException e, HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        return ResultBean.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler
    @ResponseBody
    public ResultBean unkownRuntimeException(RuntimeException e) {
        logger.warn("unkonw exception", e);
        return ResultBean.error(504, "服务异常");
    }

    @ExceptionHandler
    @ResponseBody
    public ResultBean unKonwException(Exception e) {
        logger.warn("unkonw exception", e);
        return ResultBean.error(505, "服务故障");
    }

    @ExceptionHandler
    @ResponseBody
    public ResultBean methodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request, HttpServletResponse response) {
        FieldError fieldError = e.getBindingResult().getFieldError();
        if (fieldError != null) {
            String field = fieldError.getField();
            String errorMsg = fieldError.getDefaultMessage();

            return ResultBean.error(201, errorMsg);
        }

        return ResultBean.error(201, "参数错误");
    }
}
