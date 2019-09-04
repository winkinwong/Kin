package dev.application.global;

import dev.application.model.BaseModel;
import dev.application.model.BaseModelWithId;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@Component
@Intercepts({
        @Signature(
                type= Executor.class,
                method = "update",
                args = {MappedStatement.class,Object.class}
        )
})
public class TimeUpdateIntercept implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        String mappedId = mappedStatement.getId();
        String operation = mappedId.substring(mappedId.lastIndexOf(".") + 1).toLowerCase();
        Object object = invocation.getArgs()[1];

        if (operation.contains("insert")) {
            // 插入
            if (object instanceof Map && ((Map) object).get("list") != null && ((Map) object).get("list") instanceof List && !((List) ((Map) object).get("list")).isEmpty()) {
                // 批量插入
                for (Object item : (List) ((Map) object).get("list")) {
                    autoInsertBaseModel(item);
                }
            } else {
                // 插入单条数据
                autoInsertBaseModel(object);
            }
        } else if (operation.contains("update")) {
            // 更新

            if (object != null && object instanceof Map) {
                autoUpdateBaseModel(((Map) object).get("record"));
            } else {
                autoUpdateBaseModel(object);
            }
        }

        return invocation.proceed();
    }

    /**
     * @param target 表示被拦截的对象，此处为 Executor 的实例对象
     *               作用：如果被拦截对象所在的类有实现接口，就为当前拦截对象生成一个代理对象
     *               如果被拦截对象所在的类没有指定接口，这个对象之后的行为就不会被代理操作
     * @return
     */
    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }

    /**
     * 自动为 Entity 设置 插入时间/更新时间/版本号
     *
     * @param object
     */
    protected void autoInsertBaseModel(Object object) {
        LocalDateTime now = LocalDateTime.now();

        if (object != null && object instanceof BaseModel) {
            if (((BaseModel) object).getCreateTime() == null) ((BaseModel) object).setCreateTime(now);
            if (((BaseModel) object).getUpdateTime() == null) ((BaseModel) object).setUpdateTime(now);
            if (((BaseModel) object).getVersion() == null) ((BaseModel) object).setVersion(0L);
        }

        if (object != null && object instanceof BaseModelWithId && ((BaseModelWithId) object).getId() == null) {
            // 这里可以实现自动set uuid
        }
    }

    /**
     * 自动为 Entity 更新 更新时间/版本号
     * @param object
     */
    protected void autoUpdateBaseModel(Object object) {
        LocalDateTime now = LocalDateTime.now();

        if (object != null && object instanceof BaseModel) {
            BaseModel baseModel = (BaseModel) object;
            baseModel.setUpdateTime(now);
            // 这里可以自动对版本号+1
            if (baseModel.getVersion() != null) {
                baseModel.setVersion(baseModel.getVersion() + 1);
            }
        }
    }
}
