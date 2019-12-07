package com.kin.test.springboot.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: springboot0918
 * @description: 测试记录用户操作信息
 * @author: 黄永健
 * @create: 2019-10-22 10:20
 **/
public class SysLog implements Serializable {
    //用户操作记录表主键
    private Long userLogId;
    //当前用户真实姓名
    private String userName;
    //当前操作
    private String operation;
    //调用的方法
    private String method;
    //参数
    private String params;
    //当前用户的ip地址
    private String userIpAddress;
    //当前用户操作时间
    private Date createTime;
    //记录当前返回值
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Long getUserLogId() {
        return userLogId;
    }

    public void setUserLogId(Long userLogId) {
        this.userLogId = userLogId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getUserIpAddress() {
        return userIpAddress;
    }

    public void setUserIpAddress(String userIpAddress) {
        this.userIpAddress = userIpAddress;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
