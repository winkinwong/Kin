package com.kin.test.xunjian.base;

import lombok.Data;

/**
 * @ClassName BaseResult
 * @Deacription TODO
 * @Author WinKinWong
 * @Date 2020/1/16 10:41
 * @Version 1.0
 **/

@Data
public class BaseResult<T> {
    private int code;
    private String message;
    private T data;

    public BaseResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BaseResult() {
    }
    public static <T>BaseResult success(T data){
        BaseResult result = new BaseResult();
        result.setMessage("操作成功");
        result.setCode(200);
        result.setData(data);
        return result;
    }
    public static BaseResult failed(String message,int code){
        BaseResult result = new BaseResult();
        result.setMessage(message);
        result.setCode(code);
        return result;
    }
}
