package com.ld.operation.netbox.system.entity;

import com.ld.operation.netbox.base.entity.BaseIDEntity;

import javax.persistence.Entity;
import java.util.Date;
import java.util.Objects;

@Entity(name = "sys_operation_log")
public class OperationLogEntity extends BaseIDEntity {

    private Long userId;

    private String optUrl;

    private String optContent;

    private Byte optType;

    private Date optDate;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOptUrl() {
        return optUrl;
    }

    public void setOptUrl(String optUrl) {
        this.optUrl = optUrl;
    }

    public String getOptContent() {
        return optContent;
    }

    public void setOptContent(String optContent) {
        this.optContent = optContent;
    }

    public Byte getOptType() {
        return optType;
    }

    public void setOptType(Byte optType) {
        this.optType = optType;
    }

    public Date getOptDate() {
        return optDate;
    }

    public void setOptDate(Date optDate) {
        this.optDate = optDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationLogEntity that = (OperationLogEntity) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(optUrl, that.optUrl) &&
                Objects.equals(optContent, that.optContent) &&
                Objects.equals(optType, that.optType) &&
                Objects.equals(optDate, that.optDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, optUrl, optContent, optType, optDate);
    }

    @Override
    public String toString() {
        return "OperationLogEntity{" +
                "userId=" + userId +
                ", optUrl='" + optUrl + '\'' +
                ", optContent='" + optContent + '\'' +
                ", optType=" + optType +
                ", optDate=" + optDate +
                '}';
    }
}
