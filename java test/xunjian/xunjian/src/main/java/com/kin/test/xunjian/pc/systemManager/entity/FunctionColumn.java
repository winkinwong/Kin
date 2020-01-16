package com.kin.test.xunjian.pc.systemManager.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.kin.test.xunjian.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class FunctionColumn extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 分栏id
     */
    @TableId(value = "function_column_id", type = IdType.AUTO)
    private Long functionColumnId;

    /**
     * 分栏名称
     */
    private String functionColumnName;


}
