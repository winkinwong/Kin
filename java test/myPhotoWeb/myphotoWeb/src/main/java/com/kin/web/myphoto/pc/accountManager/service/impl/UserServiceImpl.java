package com.kin.web.myphoto.pc.accountManager.service.impl;

import com.kin.web.myphoto.pc.accountManager.entity.User;
import com.kin.web.myphoto.pc.accountManager.mapper.UserMapper;
import com.kin.web.myphoto.pc.accountManager.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Kin
 * @since 2020-02-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
