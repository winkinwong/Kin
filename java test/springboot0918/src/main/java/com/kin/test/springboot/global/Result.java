package com.kin.test.springboot.global;

/**
 * @program: springboot0918
 * @description: 统一处理结果
 * @author: 黄永健
 * @create: 2019-09-18 10:49
 **/
public class Result<T> {
    private int code;
    private String message;
    private T data;


    public Result() {
    }

    public Result(int code, String message) {
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    public static Result error(int code , String message){
        Result Result = new Result(code,message);
        return Result;
    }
    public static Result success(){
        return new Result();
    }
    public static <V> Result<V> success(V data){
        Result result = new Result();
        result.setMessage("操作成功");
        result.setData(data);
        return result;
    }
}
