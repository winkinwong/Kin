package dev.application.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.List;

@TableName(value = "t_user", autoResultMap = true)
public class User extends BaseModelWithId implements Serializable {
    @TableField(value = "username")
    private String username;
    @TableField(value = "password")
    private String password;

    /**
     * 接收密码明文
     */
    @TableField(exist = false)
    private String pwd;

    @TableField(exist = false)
    private UserCard card;
    @TableField(exist = false)
    private List<Order> orders;

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserCard getCard() {
        return card;
    }

    public void setCard(UserCard card) {
        this.card = card;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
