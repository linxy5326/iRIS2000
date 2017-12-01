package com.iris.monitor.entity;

import java.util.Date;

public class Sys_AppInfo {
    private String id;

    private String appName;

    private String appVersion;

    private String appProviderinfo;

    private Date appRegtime;

    private String appUrl;

    private Date gmtModified;

    private Date gmtCreate;

    private Byte isDeleted;

    private String appIocn;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion == null ? null : appVersion.trim();
    }

    public String getAppProviderinfo() {
        return appProviderinfo;
    }

    public void setAppProviderinfo(String appProviderinfo) {
        this.appProviderinfo = appProviderinfo == null ? null : appProviderinfo.trim();
    }

    public Date getAppRegtime() {
        return appRegtime;
    }

    public void setAppRegtime(Date appRegtime) {
        this.appRegtime = appRegtime;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl == null ? null : appUrl.trim();
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getAppIocn() {
        return appIocn;
    }

    public void setAppIocn(String appIocn) {
        this.appIocn = appIocn == null ? null : appIocn.trim();
    }
}