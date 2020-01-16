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
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户真实姓名
     */
    private String userRealName;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户地址
     */
    private String address;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * ON:启用 | OFF:禁用
     */
    private String status;

    /**
     * 用户头像url
     */
    private String userPicture;

    private String companyId;

    /**
     * 性别 ： 男 or 女
     */
    private String sex;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;


}
