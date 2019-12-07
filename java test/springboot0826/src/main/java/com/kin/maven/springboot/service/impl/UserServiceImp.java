package com.kin.maven.springboot.service.impl;

import com.kin.maven.springboot.dao.UserMapper;
import com.kin.maven.springboot.exception.Error;
import com.kin.maven.springboot.exception.UserException;
import com.kin.maven.springboot.model.User;
import com.kin.maven.springboot.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Resource
    private UserMapper userMapper;
    @Override
    public Long addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public User getUserByName(String userName) {
        return userMapper.getUserByName(userName);
    }
    public User getUserByNameOfFail(String userName){
        User user = getUserByName(userName);
        if(user==null){
            throw new UserException(Error.USER_NOT_FOUND);
        }
        return user;
    }
    public List<User> getUserFotList(){
        return userMapper.getUserFotList();
    }

    public boolean delete(Long userId){
        Long i = userMapper.deleteById(userId);
        if(i==0) {
            return false;
        }
        return true;
    }
}
