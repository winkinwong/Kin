package com.kin.test.springboot.base;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author WinKinWong
 * @Description 返回值封装类
 * @Date 2019/11/12 16:43
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UploadBaseResp<T> {
    private boolean isSuccess;
    private String message;
    private T data;

    public static <T> UploadBaseResp<T> createSuccess(String message, T data) {
        return new UploadBaseResp<T>(true, message,data);
    }

    public static UploadBaseResp createFail(String message) {
        UploadBaseResp uploadBaseResp = new UploadBaseResp();
        uploadBaseResp.setMessage(message);
        uploadBaseResp.setSuccess(false);
        return uploadBaseResp;
    }
}