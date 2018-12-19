package com.ld.operation.management.aop.support;

import com.ld.operation.netbox.system.entity.LoginLogEntity;
import com.ld.operation.netbox.system.entity.OperationLogEntity;
import com.ld.operation.netbox.system.repository.LoginLogRepository;
import com.ld.operation.netbox.system.repository.OperationLogRepository;
import com.ld.operation.netbox.util.SpringContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.TimerTask;

/**
 * 日志操作任务创建工厂
 */
public class LogTaskFactory {
    private static Logger logger = LoggerFactory.getLogger(LogManager.class);
    private static OperationLogRepository operationLogRepository = SpringContextHolder.getBean(OperationLogRepository.class);
    private static LoginLogRepository loginLogRepository = SpringContextHolder.getBean(LoginLogRepository.class);

    public static TimerTask bussinessLog(final Long userId, final String url, final String content, final Byte type, final Date date) {
        return new TimerTask() {
            @Override
            public void run() {
                OperationLogEntity operationLog = LogFactory.createOperationLog(
                        userId, url, content, type, date);
                try {
                    operationLogRepository.save(operationLog);
                } catch (Exception e) {
                    logger.error("创建业务日志异常!", e);
                }
            }
        };
    }

    public static TimerTask loginLog(final Long userId, final String ip,Byte status,Date date) {
        return new TimerTask() {
            @Override
            public void run() {
                try {
                    LoginLogEntity loginLog = LogFactory.createLoginLog( userId,ip,status,date);
                    loginLogRepository.save(loginLog);
                } catch (Exception e) {
                    logger.error("创建登录日志异常!", e);
                }
            }
        };
    }
}
