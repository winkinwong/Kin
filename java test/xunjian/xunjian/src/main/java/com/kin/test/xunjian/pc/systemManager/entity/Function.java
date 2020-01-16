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
public class Function extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 权限ID
     */
    @TableId(value = "function_id", type = IdType.AUTO)
    private Long functionId;

    /**
     * 权限名
     */
    private String functionName;

    private Long functionColumnId;

    /**
     * 创建时间
     */
    private LocalDateTime creatTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 父权限id
     */
    private Long parentId;


}
