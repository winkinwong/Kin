package com.kin.maven.springboot.exception;

public enum Error {
    USER_NOT_FOUND(10001,"用户不存在"),
    USER_EXISTS(10002,"用户已存在"),
    USER_LOGIN_FAIL(10003,"登录失败"),
    USER_LOGOUT(10004,"用户已经登出"),
    USER_ALREAD_LOGIN(10005,"用户已经登录"),
    ;
    private int code;
    private String message;

    Error(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
