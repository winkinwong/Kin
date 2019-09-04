package dev.application.model;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import dev.application.global.LocalDateTimeTypeHandler;

import java.io.Serializable;
import java.time.LocalDateTime;

public class BaseModel implements Serializable {
//    @TableField(value = "create_time", whereStrategy = FieldStrategy.NOT_EMPTY)
    @TableField(value = "create_time", typeHandler = LocalDateTimeTypeHandler.class)
    private LocalDateTime createTime;
//    @TableField(value = "update_time", whereStrategy = FieldStrategy.NOT_EMPTY)
    @TableField(value = "update_time", typeHandler = LocalDateTimeTypeHandler.class)
    private LocalDateTime updateTime;
    @TableField(value = "version", whereStrategy = FieldStrategy.NOT_EMPTY)
    private Long version;

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
