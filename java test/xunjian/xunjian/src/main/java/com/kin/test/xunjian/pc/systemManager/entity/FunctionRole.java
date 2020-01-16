package com.kin.test.xunjian.pc.systemManager.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.kin.test.xunjian.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Kin
 * @since 2020-01-16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class FunctionRole extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 权限角色id
     */
    @TableId(value = "function_role_id", type = IdType.AUTO)
    private Long functionRoleId;

    /**
     * 权限id
     */
    private Long functionId;

    /**
     * 权限名
     */
    private String functionName;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
