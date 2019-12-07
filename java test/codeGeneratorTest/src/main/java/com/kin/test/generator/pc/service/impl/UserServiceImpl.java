package com.kin.test.generator.pc.service.impl;

import com.kin.test.generator.pc.entity.User;
import com.kin.test.generator.pc.mapper.UserMapper;
import com.kin.test.generator.pc.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Kin
 * @since 2019-10-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
