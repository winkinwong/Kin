package com.kin.test.generator.pc.service.impl;

import com.kin.test.generator.pc.entity.Role;
import com.kin.test.generator.pc.mapper.RoleMapper;
import com.kin.test.generator.pc.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author Kin
 * @since 2019-10-09
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
