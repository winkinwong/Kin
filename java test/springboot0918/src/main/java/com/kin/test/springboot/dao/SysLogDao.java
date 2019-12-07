package com.kin.test.springboot.dao;

import com.kin.test.springboot.model.SysLog;
import org.springframework.stereotype.Repository;

@Repository("sysLogDao")
public interface SysLogDao {
    /**
    * @Description: 保存用户操作记录
    * @Param: [sysLog]
    * @return: java.lang.Integer
    * @Author: 黄永健
    * @Date: 2019/10/22
    */
    Integer save(SysLog sysLog);
}
