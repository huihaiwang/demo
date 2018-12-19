package com.ld.operation.management.aop.support;

import com.ld.operation.netbox.system.entity.LoginLogEntity;
import com.ld.operation.netbox.system.entity.OperationLogEntity;

import java.util.Date;


/**
 * 日志对象创建工厂
 */
public class LogFactory {
    /**
     * 创建操作日志
     */
    public static OperationLogEntity createOperationLog(Long userId, String url, String content, Byte type, Date date) {
        OperationLogEntity log = new OperationLogEntity();
        log.setUserId(userId);
        log.setOptUrl(url);
        log.setOptContent(content);
        log.setOptType(type);
        log.setOptDate(date);
        return log;
    }

    /**
     * 创建登录日志
     */
    public static LoginLogEntity createLoginLog(Long userId, String ip,Byte status,Date date) {
        LoginLogEntity loginLog = new LoginLogEntity();
        loginLog.setUserId(userId);
        loginLog.setIp(ip);
        loginLog.setLoginStatus(status);
        loginLog.setRecordDate(date);
        return loginLog;
    }
}
