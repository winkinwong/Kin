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
public class UserRole extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户角色id
     */
    @TableId(value = "user_role_id", type = IdType.AUTO)
    private Long userRoleId;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
