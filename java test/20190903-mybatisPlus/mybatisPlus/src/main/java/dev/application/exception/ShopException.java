package dev.application.exception;

public class ShopException extends RuntimeException {
    private int code;

    public ShopException(int code) {
        this.code = code;
    }

    public ShopException(int code, String message) {
        super(message);
        this.code = code;
    }

    public ShopException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public ShopException(int code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    public ShopException(int code, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }
}
