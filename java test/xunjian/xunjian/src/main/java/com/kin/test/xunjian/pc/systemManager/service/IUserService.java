package com.kin.test.xunjian.pc.systemManager.service;

import com.kin.test.xunjian.pc.systemManager.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Kin
 * @since 2020-01-16
 */
public interface IUserService extends IService<User> {
    User getUserById(Long id);

    User getUserByName(String test);
}
