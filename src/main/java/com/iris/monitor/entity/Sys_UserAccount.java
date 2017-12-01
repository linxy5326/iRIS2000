package com.iris.monitor.entity;

import java.util.Date;

public class Sys_UserAccount {
    private Integer id;

    private String uaName;

    private String uaEmail;

    private String uaPwd;

    private String uaNickname;

    private Byte uaStatus;

    private Date uaRegdate;

    private Date uaExpirydate;

    private String uaDesc;

    private String uaGroup;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDeleted;

    private Integer uId;

    private String appId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUaName() {
        return uaName;
    }

    public void setUaName(String uaName) {
        this.uaName = uaName == null ? null : uaName.trim();
    }

    public String getUaEmail() {
        return uaEmail;
    }

    public void setUaEmail(String uaEmail) {
        this.uaEmail = uaEmail == null ? null : uaEmail.trim();
    }

    public String getUaPwd() {
        return uaPwd;
    }

    public void setUaPwd(String uaPwd) {
        this.uaPwd = uaPwd == null ? null : uaPwd.trim();
    }

    public String getUaNickname() {
        return uaNickname;
    }

    public void setUaNickname(String uaNickname) {
        this.uaNickname = uaNickname == null ? null : uaNickname.trim();
    }

    public Byte getUaStatus() {
        return uaStatus;
    }

    public void setUaStatus(Byte uaStatus) {
        this.uaStatus = uaStatus;
    }

    public Date getUaRegdate() {
        return uaRegdate;
    }

    public void setUaRegdate(Date uaRegdate) {
        this.uaRegdate = uaRegdate;
    }

    public Date getUaExpirydate() {
        return uaExpirydate;
    }

    public void setUaExpirydate(Date uaExpirydate) {
        this.uaExpirydate = uaExpirydate;
    }

    public String getUaDesc() {
        return uaDesc;
    }

    public void setUaDesc(String uaDesc) {
        this.uaDesc = uaDesc == null ? null : uaDesc.trim();
    }

    public String getUaGroup() {
        return uaGroup;
    }

    public void setUaGroup(String uaGroup) {
        this.uaGroup = uaGroup == null ? null : uaGroup.trim();
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

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }
}