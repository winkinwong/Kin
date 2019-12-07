package com.kin.test.springboot.service;


import com.baomidou.mybatisplus.service.IService;
import com.kin.test.springboot.global.Result;
import com.kin.test.springboot.model.User;

public interface UserService extends IService<User> {
    Result register(User user);
    Result login(String userName,String userPassword);
    Result updatePasswordById(Long userId,String userPassword);
}
