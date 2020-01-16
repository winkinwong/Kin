package com.kin.test.xunjian.pc.systemManager.controller;


import com.kin.test.xunjian.pc.systemManager.entity.User;
import com.kin.test.xunjian.pc.systemManager.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.kin.test.xunjian.base.BaseController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Kin
 * @since 2020-01-16
 */
@RestController
@RequestMapping("/systemManager/user")
public class UserController extends BaseController {
    @Resource
    private IUserService userService;

    @GetMapping("/getUser")
    public User getUserById(){
        User user = userService.getUserById(1L);
        return user;
    }

    @PostMapping("/getUserByName")
    public User getUserByName(String name){
        User user = userService.getUserByName(name);
        return user;
    }
}
