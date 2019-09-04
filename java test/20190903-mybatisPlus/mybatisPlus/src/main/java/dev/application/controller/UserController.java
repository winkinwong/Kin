package dev.application.controller;

import dev.application.global.ResultBean;
import dev.application.model.User;
import dev.application.service.UserService;
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

    @GetMapping(path = "/get")
    public ResultBean<User> getUserInfo(@NotNull  Long id) {
        User user = userService.getUserInfo(id);
        return ResultBean.success(user);
    }
}
