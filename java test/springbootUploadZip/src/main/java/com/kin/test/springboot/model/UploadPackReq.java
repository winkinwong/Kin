package com.kin.test.springboot.model;


import lombok.Data;
/**
 * @Author WinKinWong
 * @Description
 * @Date 2019/11/12 16:42
 **/
@Data
public class UploadPackReq {
    /**
     * 解压密码
     */
    private String password;

    /**
     * 解压文件存储地址
     */
    private final String destPath="E:\\Kin\\desktop\\uploadFile";

    /**
     * 区域id
     */
    private Integer partionId;
}