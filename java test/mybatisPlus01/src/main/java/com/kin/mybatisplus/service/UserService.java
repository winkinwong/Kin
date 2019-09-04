package com.kin.mybatisplus.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kin.mybatisplus.dao.UserMapper;
import com.kin.mybatisplus.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    UserMapper userMapper;
    public User getUserInfo(int userId){
        User user = getUserOrFail(userId);
        return user;
    }

    private User getUserOrFail(int userId) {
        User user = getUser(userId);
        if(user==null){
            throw new RuntimeException();
        }
        return user;
    }

    private User getUser(int userId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        //可以为空 返回一个集合查询所有的结果
       List<User> users= userMapper.selectList(queryWrapper);

        System.out.println(users.size());
        return userMapper.selectById(userId);
    }
}
