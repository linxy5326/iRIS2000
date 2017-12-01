package com.iris.monitor.entity;

import java.util.Date;

public class Sys_ResourceInfo {
    private Integer id;

    private String appId;

    private String riName;

    private String riPath;

    private String riPkgname;

    private Byte riType;

    private String riCode;

    private String riDesc;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDeleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getRiName() {
        return riName;
    }

    public void setRiName(String riName) {
        this.riName = riName == null ? null : riName.trim();
    }

    public String getRiPath() {
        return riPath;
    }

    public void setRiPath(String riPath) {
        this.riPath = riPath == null ? null : riPath.trim();
    }

    public String getRiPkgname() {
        return riPkgname;
    }

    public void setRiPkgname(String riPkgname) {
        this.riPkgname = riPkgname == null ? null : riPkgname.trim();
    }

    public Byte getRiType() {
        return riType;
    }

    public void setRiType(Byte riType) {
        this.riType = riType;
    }

    public String getRiCode() {
        return riCode;
    }

    public void setRiCode(String riCode) {
        this.riCode = riCode == null ? null : riCode.trim();
    }

    public String getRiDesc() {
        return riDesc;
    }

    public void setRiDesc(String riDesc) {
        this.riDesc = riDesc == null ? null : riDesc.trim();
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

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }
}