package com.kin.test.generator.pc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.kin.test.generator.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色-权限表(中间表)
 * </p>
 *
 * @author Kin
 * @since 2019-10-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class RoleFunction extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "role_function_id", type = IdType.AUTO)
    private Integer roleFunctionId;

    /**
     * 角色ID(role表)
     */
    private Integer roleId;

    /**
     * 权限ID(function表)
     */
    private Integer functionId;


}
