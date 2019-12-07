package com.kin.maven.springboot.controller;

import com.kin.maven.springboot.exception.Error;
import com.kin.maven.springboot.exception.UserException;
import com.kin.maven.springboot.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.*;


public class BaseController {
    private Map<String,User>users=new HashMap();
    public void SessionUser(HttpServletRequest request, User user){
        Map<String,User>loadUsers=new HashMap();
        loadUsers= (Map<String, User>) request.getSession().getAttribute("login_user");
        if(loadUsers==null){
            users.put(user.getUserName(),user);
        }else if(loadUsers.get(user.getUserName())!=null){
            throw new UserException(Error.USER_ALREAD_LOGIN);
        }//TODO 还需要一个否则条件，以上条件都不成立则往map添加新数据
        request.getSession().setAttribute("login_user",users);
    }

    public User getSessionUser(HttpServletRequest request,String userName){
        Map<String,User>loadUsers=new HashMap();
        User user = new User();
        loadUsers= (Map<String, User>) request.getSession().getAttribute("login_user");
        if(loadUsers==null){
            throw new UserException(Error.USER_LOGOUT);
        }else if(loadUsers.get(userName)!=null){
            user=loadUsers.get(userName);
        }
        return user;
    }

}
