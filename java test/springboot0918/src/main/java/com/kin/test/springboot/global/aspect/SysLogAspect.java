package com.kin.test.springboot.global.aspect;

import com.alibaba.fastjson.JSON;
import com.kin.test.springboot.global.annotation.MyLog;
import com.kin.test.springboot.global.util.DateTimeUtil;
import com.kin.test.springboot.global.util.HttpContextUtils;
import com.kin.test.springboot.global.util.ThreadLocalHelper;
import com.kin.test.springboot.model.SysLog;
import com.kin.test.springboot.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @program: springboot0918
 * @description: 系统日志：切面处理类
 * @author: 黄永健
 * @create: 2019-10-22 10:27
 **/
@Aspect
@Component
public class SysLogAspect {

    @Resource(name = "sysLogService")
    SysLogService sysLogService;

    //定义切点 @Pointcut
    //在注解的位置切入代码
    @Pointcut("@annotation(com.kin.test.springboot.global.annotation.MyLog)")
    public void logPoinCut() {
    }

    //切面 配置通知

    @AfterReturning(returning = "result",pointcut = "logPoinCut()")
    public void saveSysLog(JoinPoint joinPoint,Object result) {
        System.out.println("切面。。。。。");
        //保存日志
        SysLog sysLog = new SysLog();

        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();

        //获取操作
        MyLog myLog = method.getAnnotation(MyLog.class);
        if (myLog != null) {
            String value = myLog.value();
            sysLog.setOperation(value);//保存获取的操作
        }

        //获取请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        //获取请求的方法名
        String methodName = method.getName();
        sysLog.setMethod(className + "." + methodName);

        //请求的参数
        Object[] args = joinPoint.getArgs();
        //如果入参有request或response等，则json序列化会出现异常
        Object[] arguments  = new Object[args.length];
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof ServletRequest || args[i] instanceof ServletResponse || args[i] instanceof MultipartFile) {
                //ServletRequest不能序列化，从入参里排除，否则报异常：java.lang.IllegalStateException: It is illegal to call this method if the current request is not in asynchronous mode (i.e. isAsyncStarted() returns false)
                //ServletResponse不能序列化 从入参里排除，否则报异常：java.lang.IllegalStateException: getOutputStream() has already been called for this response
                continue;
            }
            arguments[i] = args[i];
        }
        //将参数所在的数组转换成json
        String params = "";
        if (arguments != null) {
            try {
                params = JSON.toJSONString(arguments);
            } catch (Exception e) {
                params = arguments.toString();
            }
        }
        sysLog.setParams(params);
        sysLog.setCreateTime(new Date());
        //获取用户名
        sysLog.setUserName(ThreadLocalHelper.getSessionUser().getUserName());
        //获取用户ip地址
        sysLog.setUserIpAddress(HttpContextUtils.getIpAddress());

        String jsonResult = JSON.toJSONString(result);
        sysLog.setResult(jsonResult);
        //调用service保存SysLog实体类到数据库
        String message = sysLogService.save(sysLog);
        System.out.println("返回结果测试："+jsonResult);
        System.out.println(message);
    }

}
