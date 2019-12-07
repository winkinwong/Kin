package cn.bd.test.springmvc.controller;

import cn.bd.test.springmvc.dao.UserMapper;
import cn.bd.test.springmvc.entity.User;
import cn.bd.test.springmvc.global.ResultBean;
import cn.bd.test.springmvc.listener.MySessionContext;
import cn.bd.test.springmvc.service.UserService;
import com.sun.istack.internal.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.Map;

/**
 * @program: spingmvc0919
 * @description: 用户登录、注册、修改控制器
 * @author: 黄永健
 * @create: 2019-09-19 10:44
 **/
@Controller
@RequestMapping("/api/user")
public class UserController {

    @Resource(name = "userService")
    private UserService userService;
    @Resource(name = "UserMapper")
    private UserMapper userMapper;
    //TODO 注册先检查是否有存在用户
//    @RequestMapping(value = "/register",method = RequestMethod.GET,produces="text/html;charset=UTF-8")
    //局部解决该方法的乱码问题。
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    @ResponseBody
    public ResultBean register(User user, HttpServletResponse response){
        System.out.println("test");
        System.out.println(user.toString());
        //response.setHeader("Content-Type", "application/json");
        return userService.register(user);
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @ResponseBody
    public ResultBean login(@NotNull String userName, @NotNull String userPassword, HttpServletRequest request){
        ResultBean resultBean = userService.login(userName,userPassword);
        if(resultBean.getCode()!=200){
            System.out.println("登录失败");
            return resultBean;
        }
        Map<String,Object>data = (Map<String, Object>) resultBean.getData();
        Object loginUserName = data.get("userName");
        HttpSession session = request.getSession();
        session.setAttribute("login_user",loginUserName);
        System.out.println(session.getAttribute("login_user"));
        return new ResultBean(200,"登录成功");
    }

    //admin 查看当前用户登录数以及所有登录用户名

    @RequestMapping("/admin")
    @ResponseBody
    public ResultBean admin(HttpServletRequest request){
        //获取的只是根据当前sessionid获取用户
        Object userName = request.getSession().getAttribute("login_user");
        return new ResultBean(200,"操作成功",userName);
    }

    //test
    @RequestMapping("/test")
    public String test(){
        System.out.println("test");
        return "success";
    }


//    会在每个目标方法执行之前被springmvc调用
    //只是针对 POJO 修改部分属性时，指定字段修改不需使用该方法。（这里作为例子）
    @ModelAttribute
    public void getUser(@RequestParam("userName")String userName,Map<String,Object>map){
        System.out.println("ModelAttribute method");
        if(userName != null){
            User user = userMapper.getUserByUserName(userName);
            System.out.println("从数据库中获取指定用户信息");
            if(user!=null){
                map.put("user",user);
            }

        }
    }

    //修改用户密码
    @RequestMapping("/updatePassword")
    @ResponseBody
    public ResultBean updatePassword(User user){
        System.out.println("修改后的user"+user);
        ResultBean resultBean = userService.updatePassword(user.getUserPassword(),user.getUserName());
        if(resultBean.getCode()!=200){
            System.out.println("修改失败");
            return resultBean;
        }
        return resultBean;
    }

    @RequestMapping("/select")
    @ResponseBody
    public ResultBean selectUserByConditions(@NotNull Long lowerLimit,Long upperLimit){
        System.out.println();
        System.out.println("###################This is selectUserByConditions####################");
        return userService.selectUserByConditions(lowerLimit,upperLimit);
    }

}
