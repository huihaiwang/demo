package com.ld.operation.management.aop;


import com.fasterxml.jackson.databind.ObjectMapper;
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
 * 日志记录
 */
@Aspect
@Component
public class LogAop {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    private static final String SAVE = "save";
    private static final  String INSERT = "insert";
    private static final String DELETE ="delete";
    private static final String REMOVE = "remove";
    private static final String UPDATE = "update";
    private static final String GET = "get";
    private static final String LIST = "list";

    @Pointcut(value = "execution(* com.ld.operation.management.*.controller..*.*(..)) && !execution(* com.ld.operation.management.system.controller.LoginController.*(..)))")
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
        Byte type =getType(methodName);
        if(type==null){
            log.warn(methodName+"方法命名不规范,无法解析操作日志!");
            return;
        }
        //获取request
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        //请求url
        String url = request.getRequestURI();

        //获取拦截方法的参数
        StringBuilder parameter = new StringBuilder();
        Object params = null;
        if ("GET".equalsIgnoreCase(request.getMethod())) {
           params = request.getQueryString();
        } else {
            params = request.getParameterMap();
        }
        if(params!=null){
            parameter.append(params);
        }

        LogManager.me().executeLog(LogTaskFactory.bussinessLog(SessionUtil.currentUserId(), url, parameter.toString(), type, new Date()));
    }

    private Byte getType(String name){
        if(StringUtils.isBlank(name)){
            return null;
        }else if(name.toLowerCase().startsWith(GET)||name.toLowerCase().startsWith(LIST)){
            return 1;
        }else if(name.toLowerCase().startsWith(SAVE)||name.toLowerCase().startsWith(INSERT)){
            return 2;
        }else if(name.toLowerCase().startsWith(UPDATE)){
            return 3;
        }else if(name.toLowerCase().startsWith(DELETE)||name.toLowerCase().startsWith(REMOVE)){
            return 4;
        }
        return null;
    }

}
