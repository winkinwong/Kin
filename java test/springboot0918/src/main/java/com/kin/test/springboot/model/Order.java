package com.kin.test.springboot.model;

/**
 * @program: springboot0918
 * @description: 订单实体类
 * @author: 黄永健
 * @create: 2019-09-18 10:39
 **/
public class Order {
    private Long orderId;
    private String orderNum;
    private String orderContent;
    private Long userId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getOrderContent() {
        return orderContent;
    }

    public void setOrderContent(String orderContent) {
        this.orderContent = orderContent;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
