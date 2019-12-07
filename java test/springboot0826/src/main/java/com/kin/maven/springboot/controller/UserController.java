package com.kin.maven.springboot.controller;


import com.kin.maven.springboot.exception.Error;
import com.kin.maven.springboot.exception.UserException;
import com.kin.maven.springboot.global.ResultBean;
import com.kin.maven.springboot.global.ThreadLocalHelper;
import com.kin.maven.springboot.model.User;
import com.kin.maven.springboot.service.impl.UserServiceImp;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;

@RequestMapping(path = "/api/user")
@RestController
public class UserController extends BaseController{

    @Resource
    private UserServiceImp userServiceImp;

    //TODO 注册用户需要明确返回值类型为统一返回类型
    @GetMapping(path = "/add")
    public ResultBean registUser(User user){
        /*
        * 先判断用户名是否已经存在
        * */
        User alreadyUser = userServiceImp.getUserByName(user.getUserName());
        if(alreadyUser!=null){
            throw new UserException(Error.USER_EXISTS);
        }
        String EncodePsd = DigestUtils.sha512Hex(user.getPassword());
        User register = new User();
        register.setUserName(user.getUserName());
        register.setPassword(EncodePsd);
        userServiceImp.addUser(register);
        return ResultBean.success();
    }

    @GetMapping(path = "/login")
    public ResultBean login(@NotNull String userName, @NotNull String password, HttpServletRequest request){
        /*
        * 首先需要查询用户名是否存在，如果不存在直接抛出异常
        * */
        User loginUser = userServiceImp.getUserByNameOfFail(userName);
        String encodePsd = DigestUtils.sha512Hex(password);
        if(!encodePsd.equals(loginUser.getPassword())){
            throw new UserException(Error.USER_LOGIN_FAIL);
        }
        HttpSession session = request.getSession();
        session.setAttribute("login_user",loginUser);
        ThreadLocalHelper.setSessionUser(loginUser);
       // SessionUser(request,loginUser);
        return ResultBean.success(loginUser);
    }

    @GetMapping(path = "/getuser")
    public ResultBean getUser(HttpServletRequest request,@NotNull String userName){
        User user = getSessionUser(request,userName);
        return ResultBean.success(user);
    }

    @GetMapping(path = "/getcurrentuser")
    public ResultBean getCurrentUser(){
        User sessionUser = ThreadLocalHelper.getSessionUser();
        if(sessionUser==null){
            throw new UserException(Error.USER_LOGOUT);
        }
        return ResultBean.success(sessionUser);
    }

}
