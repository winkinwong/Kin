package com.kin.test.xunjian.base;


public enum BaseEnum {
    PARAMS_INPUT_ERROR(400001,"请求参数传入错误"),
    ;

    private Integer code;
    private String message;

    BaseEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
