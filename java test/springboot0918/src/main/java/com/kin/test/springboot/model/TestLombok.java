package com.kin.test.springboot.model;

import lombok.Data;

import java.util.Date;

/**
 * @Author WinKinWong
 * @Description 测试Lombok自动生成get、set方法
 * @Date 2019/11/7 15:02
 **/
@Data
public class TestLombok {
    private String name;
    private Date time;
}
