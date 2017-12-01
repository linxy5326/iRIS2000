package com.iris.monitor.entity;

import java.util.Date;

public class Sys_MenuInfo {
    private Integer id;

    private String mName;

    private String mAkey;

    private String mCode;

    private Float mOrdernum;

    private Integer rId;

    private String appId;

    private String mIcon;

    private Byte mIsenabeld;

    private Byte mIsshow;

    private Integer mParent;

    private Date mUrl;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDeleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName == null ? null : mName.trim();
    }

    public String getmAkey() {
        return mAkey;
    }

    public void setmAkey(String mAkey) {
        this.mAkey = mAkey == null ? null : mAkey.trim();
    }

    public String getmCode() {
        return mCode;
    }

    public void setmCode(String mCode) {
        this.mCode = mCode == null ? null : mCode.trim();
    }

    public Float getmOrdernum() {
        return mOrdernum;
    }

    public void setmOrdernum(Float mOrdernum) {
        this.mOrdernum = mOrdernum;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getmIcon() {
        return mIcon;
    }

    public void setmIcon(String mIcon) {
        this.mIcon = mIcon == null ? null : mIcon.trim();
    }

    public Byte getmIsenabeld() {
        return mIsenabeld;
    }

    public void setmIsenabeld(Byte mIsenabeld) {
        this.mIsenabeld = mIsenabeld;
    }

    public Byte getmIsshow() {
        return mIsshow;
    }

    public void setmIsshow(Byte mIsshow) {
        this.mIsshow = mIsshow;
    }

    public Integer getmParent() {
        return mParent;
    }

    public void setmParent(Integer mParent) {
        this.mParent = mParent;
    }

    public Date getmUrl() {
        return mUrl;
    }

    public void setmUrl(Date mUrl) {
        this.mUrl = mUrl;
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