package com.kin.test.springboot.service.imp;

import com.kin.test.springboot.dao.SysLogDao;
import com.kin.test.springboot.global.annotation.MyLog;
import com.kin.test.springboot.model.SysLog;
import com.kin.test.springboot.service.SysLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: springboot0918
 * @description: 系统日志服务实现类
 * @author: 黄永健
 * @create: 2019-10-22 10:32
 **/
@Service("sysLogService")
public class SysLogServiceImp implements SysLogService {
    @Resource(name = "sysLogDao")
    SysLogDao sysLogDao;
    @Override
    public String save(SysLog sysLog) {
        Integer flag = sysLogDao.save(sysLog);
        if (flag>0){
            return "保存成功";
        }else {
            return "保存失败";
        }

    }
}
