package com.kin.test.generator.pc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.kin.test.generator.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author Kin
 * @since 2019-10-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String userPassword;

    /**
     * 真实姓名
     */
    private String userRealname;

    /**
     * 年龄
     */
    private Integer userAge;

    /**
     * 性别
     */
    private String userGender;

    /**
     * 电话
     */
    private String userPhoneNumber;

    /**
     * 职务
     */
    private String userPosition;

    /**
     * 用户头像图片的访问路径
     */
    private String userPictureUrl;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 状态值
     */
    private String status;

    /**
     * 公司ID(company表)
     */
    private Integer companyId;


}
