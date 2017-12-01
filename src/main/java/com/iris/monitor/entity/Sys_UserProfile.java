package com.iris.monitor.entity;

import java.util.Date;

public class Sys_UserProfile {
    private Integer id;

    private Date gmtCreate;

    private Date gmtModified;

    private Integer uaId;

    private String pfData;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getUaId() {
        return uaId;
    }

    public void setUaId(Integer uaId) {
        this.uaId = uaId;
    }

    public String getPfData() {
        return pfData;
    }

    public void setPfData(String pfData) {
        this.pfData = pfData == null ? null : pfData.trim();
    }
}