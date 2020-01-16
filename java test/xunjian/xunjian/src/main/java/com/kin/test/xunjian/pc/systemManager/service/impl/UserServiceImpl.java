package com.kin.test.xunjian.pc.systemManager.service.impl;

import com.kin.test.xunjian.pc.systemManager.entity.User;
import com.kin.test.xunjian.pc.systemManager.mapper.UserMapper;
import com.kin.test.xunjian.pc.systemManager.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Kin
 * @since 2020-01-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserById(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public User getUserByName(String test) {
        return userMapper.getUserByName(test);
    }
}
