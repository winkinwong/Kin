package com.kin.mybatisplus.controller;

import com.kin.mybatisplus.model.User;
import com.kin.mybatisplus.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {
    @Resource
    UserService userService;

    @GetMapping(path = "/getinfo")
    public User getUserInfo(@NotNull int userId){
        User user = userService.getUserInfo(userId);
        return user;
    }
}
