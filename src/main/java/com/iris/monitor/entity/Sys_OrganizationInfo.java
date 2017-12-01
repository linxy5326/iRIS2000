package com.iris.monitor.entity;

import java.util.Date;

public class Sys_OrganizationInfo {
    private String id;

    private String appId;

    private String orgName;

    private String orgCode;

    private String orgParent;

    private String orgIndexcode;

    private String orgAddress;

    private Byte orgType;

    private Byte orgStatus;

    private Byte isDeleted;

    private Date gmtCreate;

    private Date gmtModified;

    private String orgJianjie;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public String getOrgParent() {
        return orgParent;
    }

    public void setOrgParent(String orgParent) {
        this.orgParent = orgParent == null ? null : orgParent.trim();
    }

    public String getOrgIndexcode() {
        return orgIndexcode;
    }

    public void setOrgIndexcode(String orgIndexcode) {
        this.orgIndexcode = orgIndexcode == null ? null : orgIndexcode.trim();
    }

    public String getOrgAddress() {
        return orgAddress;
    }

    public void setOrgAddress(String orgAddress) {
        this.orgAddress = orgAddress == null ? null : orgAddress.trim();
    }

    public Byte getOrgType() {
        return orgType;
    }

    public void setOrgType(Byte orgType) {
        this.orgType = orgType;
    }

    public Byte getOrgStatus() {
        return orgStatus;
    }

    public void setOrgStatus(Byte orgStatus) {
        this.orgStatus = orgStatus;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
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

    public String getOrgJianjie() {
        return orgJianjie;
    }

    public void setOrgJianjie(String orgJianjie) {
        this.orgJianjie = orgJianjie == null ? null : orgJianjie.trim();
    }
}