package cn.bd.test.springmvc.service.imp;

import cn.bd.test.springmvc.dao.UserMapper;
import cn.bd.test.springmvc.entity.User;
import cn.bd.test.springmvc.global.ResultBean;
import cn.bd.test.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: spingmvc0919
 * @description: 用户服务实现类
 * @author: 黄永健
 * @create: 2019-09-19 10:49
 **/
@Service("userService")
public class UserServcieImp implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public ResultBean register(User user) {
        User userAlready = userMapper.getUserByUserName(user.getUserName());

        if(userAlready!=null){
            System.out.println(userAlready.toString());
            return new ResultBean(403,"用户已存在");
        }
        String password =DigestUtils.sha512Hex(user.getUserPassword());
        User userRegister = new User();
        userRegister.setUserName(user.getUserName());
        userRegister.setUserPassword(password);
        userRegister.setAddress(user.getAddress());
        userRegister.setPhone(user.getPhone());
        userRegister.setCreateTime(new Date());
        Integer code = userMapper.register(userRegister);
        if (code!=1){
            return new ResultBean(400,"注册失败");
        }
        return new ResultBean(200,"注册成功");
    }

    @Override
    public ResultBean login(String userName, String userPassword) {

        String password = DigestUtils.sha512Hex(userPassword);
        User user = userMapper.login(userName,password);
        if(user==null){
            return new ResultBean(400,"用户或密码错误");
        }
        Map<String,Object>data=new HashMap<String, Object>();
        data.put("userName",user.getUserName());
        return new ResultBean(200,"登录成功",data);
    }

    @Override
    public ResultBean updatePassword(String userPassword,String userName) {
        String password = DigestUtils.sha512Hex(userPassword);
        int code = userMapper.updatePassword(password,userName);
        if(code != 1){
            return new ResultBean(400,"修改失败");
        }
        return new ResultBean(200,"修改成功");
    }

    @Override
    public ResultBean selectUserByConditions(Long lowerLimit,Long upperLimit) {
         List<User> users= userMapper.selectUserByConditions(lowerLimit,upperLimit);
        return new ResultBean(200,"查询成功",users);
    }


}
