package cn.bd.test.springmvc.service;

import cn.bd.test.springmvc.entity.User;
import cn.bd.test.springmvc.global.ResultBean;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    ResultBean register(User user);
    ResultBean login(String userName, String userPassword);
    ResultBean updatePassword(String userPassword,String userName);
    ResultBean selectUserByConditions(Long lowerLimit,Long upperLimit);
}
