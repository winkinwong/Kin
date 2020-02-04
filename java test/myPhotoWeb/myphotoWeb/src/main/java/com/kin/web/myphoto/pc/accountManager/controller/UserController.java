package com.kin.web.myphoto.pc.accountManager.controller;


import com.kin.web.myphoto.exception.Error;
import com.kin.web.myphoto.exception.UserException;
import com.kin.web.myphoto.global.ResultBean;
import com.kin.web.myphoto.global.ThreadLocalHelper;
import com.kin.web.myphoto.pc.accountManager.dto.UserDTO;
import com.kin.web.myphoto.pc.accountManager.entity.User;
import com.kin.web.myphoto.pc.accountManager.req.UserReq;
import com.kin.web.myphoto.pc.accountManager.service.IUserService;
import org.springframework.web.bind.annotation.*;

import com.kin.web.myphoto.base.BaseController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Kin
 * @since 2020-02-02
 */
@RestController
@RequestMapping("/accountManager/user")
public class UserController extends BaseController {
    @Resource
    private IUserService userService;

    //注册账号
    @PostMapping("/registerAccount")
    public ResultBean registerAccount(@RequestBody UserDTO userDTO) throws Exception {
        userService.registerAccount(userDTO);
        return ResultBean.success();
    }
    //登录
    @PostMapping("/loginAccount")
    public ResultBean loginAccount(@RequestBody UserReq req, HttpServletRequest request){
        User user = userService.loginAccount(req);
        //将登陆信息放入session
        HttpSession session = request.getSession();
        //这个让前端获取的登陆信息
        session.setAttribute("login_user",user);
        return ResultBean.success("登陆成功");
    }
    //登出
    @GetMapping("/logoutAccount")
    public ResultBean logoutAccount(HttpServletRequest request){
        User user = ThreadLocalHelper.getSessionUser();
        if (user==null){
            throw new UserException(Error.USER_LOGOUT);
        }
        HttpSession session = request.getSession();
        session.invalidate();
        return ResultBean.success("已登出");
    }
}
