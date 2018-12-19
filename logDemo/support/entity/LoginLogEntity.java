package com.ld.operation.netbox.system.entity;

import com.ld.operation.netbox.base.entity.BaseIDEntity;

import javax.persistence.Entity;
import java.util.Date;
import java.util.Objects;

@Entity(name = "sys_login_log")
public class LoginLogEntity extends BaseIDEntity {
    private Long userId;

    private String ip;

    private Byte loginStatus;

    private Date recordDate;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Byte getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(Byte loginStatus) {
        this.loginStatus = loginStatus;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    @Override
    public String toString() {
        return "LoginLogEntity{" +
                "userId=" + userId +
                ", ip='" + ip + '\'' +
                ", loginStatus=" + loginStatus +
                ", recordDate=" + recordDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginLogEntity that = (LoginLogEntity) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(ip, that.ip) &&
                Objects.equals(loginStatus, that.loginStatus) &&
                Objects.equals(recordDate, that.recordDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, ip, loginStatus, recordDate);
    }
}
