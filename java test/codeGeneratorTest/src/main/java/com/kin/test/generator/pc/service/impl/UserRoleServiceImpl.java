package com.kin.test.generator.pc.service.impl;

import com.kin.test.generator.pc.entity.UserRole;
import com.kin.test.generator.pc.mapper.UserRoleMapper;
import com.kin.test.generator.pc.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户-角色表(中间表) 服务实现类
 * </p>
 *
 * @author Kin
 * @since 2019-10-09
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
