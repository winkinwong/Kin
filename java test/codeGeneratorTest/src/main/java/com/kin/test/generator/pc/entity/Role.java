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
 * 角色表
 * </p>
 *
 * @author Kin
 * @since 2019-10-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Role extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "role_id", type = IdType.AUTO)
    private Integer roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 展示角色的顺序
     */
    private Integer roleShowNumber;

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

    /**
     * 展示角色的公司ID(company表)
     */
    private Integer showCompanyId;


}
