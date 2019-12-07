package com.kin.test.springboot.controller;

import com.kin.test.springboot.global.Result;
import com.kin.test.springboot.global.annotation.MyLog;
import com.kin.test.springboot.global.util.ThreadLocalHelper;
import com.kin.test.springboot.model.User;
import com.kin.test.springboot.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;

/**
 * @program: springboot0918
 * @description: 用户登录、注册、退出
 * @author: 黄永健
 * @create: 2019-09-18 10:47
 **/
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Resource
    private UserService userService;
    //TODO 注册用户先判断数据库中是否存在已有用户
    @MyLog(value = "注册用户")
    @PostMapping("/register")
    public Result register(@NotNull User user,HttpServletRequest request){
        HttpSession session = request.getSession();
        Result result = userService.register(user);
        User user1 =new User();
        user1= (User) result.getData();
        session.setAttribute("login_user",user1);
        ThreadLocalHelper.setSessionUser(user1);
        return result;
    }

    @PostMapping("/login")
    public Result login(@NotNull String userName, @NotNull String userPassword, HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) userService.login(userName,userPassword).getData();
        session.setAttribute("login_user",user);
        ThreadLocalHelper.setSessionUser(user);
        return new Result(200,"登录成功");
    }

    @PostMapping("/update")
    @MyLog(value = "修改用户密码")
    public Result updatePassword(@NotNull Long userId,String userPassword){
        return  userService.updatePasswordById(userId,userPassword);
    }
}
