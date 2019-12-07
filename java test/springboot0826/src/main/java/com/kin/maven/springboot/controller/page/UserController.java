package com.kin.maven.springboot.controller.page;


import com.kin.maven.springboot.controller.BaseController;
import com.kin.maven.springboot.exception.Error;
import com.kin.maven.springboot.exception.UserException;
import com.kin.maven.springboot.global.ResultBean;
import com.kin.maven.springboot.global.ThreadLocalHelper;
import com.kin.maven.springboot.model.User;
import com.kin.maven.springboot.service.impl.UserServiceImp;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.List;

@RequestMapping(path = "/user")
@Controller("UserController4Page")
public class UserController extends BaseController{

    @Resource
    private UserServiceImp userServiceImp;

    @GetMapping(path = "/info")
    public ModelAndView getUserInfo(@NotNull String userName){
        ModelAndView view = new ModelAndView("user/info");
        User user = userServiceImp.getUserByNameOfFail(userName);
        view.addObject("userName",user.getUserName());
        view.addObject("user",user);
        List<User> userList = userServiceImp.getUserFotList();
        view.addObject("userlist",userList);
        System.out.println(view);
        return view;
    }

    @GetMapping(path = "/list")
    public ModelAndView list(){
        ModelAndView view = new ModelAndView("user/info");
        List<User>userList = userServiceImp.getUserFotList();
        view.addObject("userlist",userList);
        return view;
    }


    @GetMapping(path = "/delete")
    public String delete(@NotNull Long userId, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (userServiceImp.delete(userId)){
            System.out.println("删除成功");
            return "redirect:/user/list";
        }
        /*RequestDispatcher requestDispatcher = request.getRequestDispatcher("/user/list");
        requestDispatcher.forward(request,response);*/ //可以通过servlet进行转发重定向操作
        return "forward:/user/list";
    }




}
