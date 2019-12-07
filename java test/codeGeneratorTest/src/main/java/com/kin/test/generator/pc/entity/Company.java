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
 * 公司表
 * </p>
 *
 * @author Kin
 * @since 2019-10-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Company extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "company_id", type = IdType.AUTO)
    private Integer companyId;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 状态值
     */
    private String status;


}
