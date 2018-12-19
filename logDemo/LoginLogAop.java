package com.ld.operation.management.aop;


import com.ld.operation.management.aop.support.LogManager;
import com.ld.operation.management.aop.support.LogTaskFactory;
import com.ld.operation.management.shiro.SessionUtil;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 登录日志记录
 */
@Aspect
@Component
public class LoginLogAop {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    private static final String LOGIN= "login";
    private static final  String LOGOUT = "logout";

    @Pointcut(value = "execution(* com.ld.operation.management.system.controller.LoginController.*(..))")
    public void cutService() {
    }

    @Around("cutService()")
    public Object recordSysLog(ProceedingJoinPoint point) throws Throwable {

        //先执行业务
        Object result = point.proceed();

        try {
            handle(point);
        } catch (Exception e) {
            log.error("日志记录出错!", e);
        }

        return result;
    }

    private void handle(ProceedingJoinPoint point) throws Exception {
        //获取拦截操作类型
        String methodName = point.getSignature().getName();
        byte type =getType(methodName);

        //获取request
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        //IP
        String ip =getIpAddress(request);

        LogManager.me().executeLog(LogTaskFactory.loginLog(SessionUtil.currentUserId(), ip,type, new Date()));
    }

    private Byte getType(String name){
        if(StringUtils.isBlank(name)){
            throw new RuntimeException(name+"方法命名不规范!");
        }else if(name.toLowerCase().endsWith(LOGIN)){
            return 1;
        }else if(name.toLowerCase().endsWith(LOGOUT)) {
            return 0;
        }
        throw new RuntimeException(name+"方法命名不规范!");
    }

    private   String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}
