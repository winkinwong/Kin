package dev.application.exception;

public enum ErrorCode {
    USER_NOT_FOUND(10001, "用户不存在"),
    USER_ADD_FAIL(10002, "添加失败"),
    USER_CARD_ADD_FAIL(10003, "添加用户身份证失败"),
    USER_ALREADY_EXIST(10004, "账号已存在"),
    USER_LOGIN_FAIL(10005, "账号或密码不正确"),
    USER_LOGOUT(10006, "请先登录"),
    USER_CARD_NOT_FOUND(10007, "用户身份记录不存在"),

    ORDER_NOT_FOUND(11001, "订单不存在"),

    GLOBAL_USER_LOGIN_FAIL(401, "账号或密码不正确"),
    ;

    private Integer code;
    private String msg;

    private ErrorCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
