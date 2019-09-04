package dev.application.exception;

public class UserException extends RuntimeException {
    private int code;

    public UserException() {
    }

    public UserException(Throwable cause) {
        super(cause);
    }

    public UserException(ErrorCode errorCode) {
        this(errorCode.getCode(), errorCode.getMsg());
    }

    public UserException(ErrorCode errorCode, Throwable cause) {
        this(errorCode.getCode(), errorCode.getMsg(), cause);
    }

    public UserException(ErrorCode errorCode, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        this(errorCode.getCode(), errorCode.getMsg(), cause, enableSuppression, writableStackTrace);
    }

    public UserException(int code) {
        super();
        this.code = code;
    }

    public UserException(int code, String message) {
        super(message);
        this.code = code;
    }

    public UserException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public UserException(int code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    protected UserException(int code, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

//    public void setCode(int code) {
//        this.code = code;
//    }
}
