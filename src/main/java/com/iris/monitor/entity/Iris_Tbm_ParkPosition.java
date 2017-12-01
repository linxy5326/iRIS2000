package com.iris.monitor.entity;

import java.util.Date;

public class Iris_Tbm_ParkPosition {
    private Integer id;

    private String tpkAddress;

    private String tpkName;

    private String tpkPosition;

    private Date gmtCreate;

    private Date gmtModified;

    private String tpkDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTpkAddress() {
        return tpkAddress;
    }

    public void setTpkAddress(String tpkAddress) {
        this.tpkAddress = tpkAddress == null ? null : tpkAddress.trim();
    }

    public String getTpkName() {
        return tpkName;
    }

    public void setTpkName(String tpkName) {
        this.tpkName = tpkName == null ? null : tpkName.trim();
    }

    public String getTpkPosition() {
        return tpkPosition;
    }

    public void setTpkPosition(String tpkPosition) {
        this.tpkPosition = tpkPosition == null ? null : tpkPosition.trim();
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

    public String getTpkDesc() {
        return tpkDesc;
    }

    public void setTpkDesc(String tpkDesc) {
        this.tpkDesc = tpkDesc == null ? null : tpkDesc.trim();
    }
}