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
public class Company extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 公司id
     */
    @TableId(value = "company_id", type = IdType.AUTO)
    private Long companyId;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 公司状态 FORMAL:正常 | CLOSE:关闭
     */
    private String companyStatus;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 公司地址
     */
    private String companyAddress;


}
