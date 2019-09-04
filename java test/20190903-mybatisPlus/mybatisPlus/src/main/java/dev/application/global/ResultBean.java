package dev.application.global;

public class ResultBean<T> {
    private int code;
    private String msg;
    private String requestId;
    private T data;

    public ResultBean() {}

    public ResultBean(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResultBean error(int code, String msg) {
        return new ResultBean(code, msg);
    }

    public static ResultBean success() {
        return new ResultBean();
    }

    public static <V> ResultBean<V> success(V data) {
        ResultBean<V> success = new ResultBean<>();
        success.setData(data);

        return success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
