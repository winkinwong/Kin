package com.kin.test.springboot.service.imp;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.kin.test.springboot.dao.UserMapper;
import com.kin.test.springboot.exception.Error;
import com.kin.test.springboot.exception.UserException;
import com.kin.test.springboot.global.Result;
import com.kin.test.springboot.model.TestLombok;
import com.kin.test.springboot.model.User;
import com.kin.test.springboot.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @program: springboot0918
 * @description: 用户表 实现类
 * @author: 黄永健
 * @create: 2019-09-18 11:31
 **/
@Service
public class UserServiceImp extends ServiceImpl<UserMapper,User> implements UserService{
    @Autowired
    private UserMapper userMapper;

    /**
    * @Description: 
    * @Param: [userInfo]
    * @return: com.kin.test.springboot.global.Result
    * @Author: 黄永健
    * @Date: 2019/9/26
    */
    @Override
    public Result register(User userInfo){
        User userParm = new User();
        userParm.setUserName(userInfo.getUserName());
        User userAlready = userMapper.selectOne(userParm);

        if(userAlready!=null){
             throw new UserException(Error.USER_EXISTS);
        }
        User user = new User();
        user.setUserName(userInfo.getUserName());
        String password = DigestUtils.sha512Hex(userInfo.getUserPassword());
        user.setUserPassword(password);
        user.setUserAddress(userInfo.getUserAddress());
        user.setUserPhone(userInfo.getUserPhone());
        user.setCreateTime(new Date());
        userMapper.insert(user);
        return Result.success(user);
    }

    /**
    * @Description: 
    * @Param: [userName, userPassword]
    * @return: com.kin.test.springboot.global.Result
    * @Author: 黄永健
    * @Date: 2019/9/26
    */
    @Override
    public Result login(String userName, String userPassword) {
        User user = getUserOrFail(userName,userPassword);
        return Result.success(user);
    }
    /**
    * @Description: 
    * @Param: [userId, userPassword]
    * @return: com.kin.test.springboot.global.Result
    * @Author: 黄永健
    * @Date: 2019/9/26
    */
    @Override
    public Result updatePasswordById(Long userId,String userPassword) {
        String password = DigestUtils.sha512Hex(userPassword);
        User updateUser = new User();
        updateUser.setUserId(userId);
        updateUser.setUserPassword(password);
        updateUser.setUpdateTime(new Date());
        userMapper.updateById(updateUser);
        User user = userMapper.selectById(userId);
        return Result.success(user);
    }
    /**
    * @Description: 
    * @Param: [userName, userPassword]
    * @return: com.kin.test.springboot.model.User
    * @Author: 黄永健
    * @Date: 2019/9/26
    */
    public User getUserOrFail(String userName,String userPassword){
        User user = new User();
        String password = DigestUtils.sha512Hex(userPassword);
        user = userMapper.login(userName,password);
        if(user==null){
            throw new UserException(Error.USER_LOGIN_FAIL);
        }
        return user;
    }
}
