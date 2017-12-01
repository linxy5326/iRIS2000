package com.iris.monitor.entity;

import java.util.Date;

public class Iris_Ici_Ui {
    private Integer id;

    private String uiName;

    private String uiPath;

    private Integer uiIndex;

    private String uiDesc;

    private Byte uiEnabled;

    private Date gmtCerate;

    private Date gmtModified;

    private Byte isDeleted;

    private Byte uiVisible;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUiName() {
        return uiName;
    }

    public void setUiName(String uiName) {
        this.uiName = uiName == null ? null : uiName.trim();
    }

    public String getUiPath() {
        return uiPath;
    }

    public void setUiPath(String uiPath) {
        this.uiPath = uiPath == null ? null : uiPath.trim();
    }

    public Integer getUiIndex() {
        return uiIndex;
    }

    public void setUiIndex(Integer uiIndex) {
        this.uiIndex = uiIndex;
    }

    public String getUiDesc() {
        return uiDesc;
    }

    public void setUiDesc(String uiDesc) {
        this.uiDesc = uiDesc == null ? null : uiDesc.trim();
    }

    public Byte getUiEnabled() {
        return uiEnabled;
    }

    public void setUiEnabled(Byte uiEnabled) {
        this.uiEnabled = uiEnabled;
    }

    public Date getGmtCerate() {
        return gmtCerate;
    }

    public void setGmtCerate(Date gmtCerate) {
        this.gmtCerate = gmtCerate;
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

    public Byte getUiVisible() {
        return uiVisible;
    }

    public void setUiVisible(Byte uiVisible) {
        this.uiVisible = uiVisible;
    }
}