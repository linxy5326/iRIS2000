package com.iris.monitor.entity;

import java.util.Date;

public class Iris_Project {
    private String id;

    private String orgId;

    private String piPmcode;

    private String piName;

    private String piProvince;

    private String piPosition;

    private String piYzdw;

    private String piCbdw;

    private String piSgdw;

    private String piAddress;

    private Date piOpendate;

    private Date piColsedate;

    private Byte piStatus;

    private Byte piFlag;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDeleted;

    private String piDesc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getPiPmcode() {
        return piPmcode;
    }

    public void setPiPmcode(String piPmcode) {
        this.piPmcode = piPmcode == null ? null : piPmcode.trim();
    }

    public String getPiName() {
        return piName;
    }

    public void setPiName(String piName) {
        this.piName = piName == null ? null : piName.trim();
    }

    public String getPiProvince() {
        return piProvince;
    }

    public void setPiProvince(String piProvince) {
        this.piProvince = piProvince == null ? null : piProvince.trim();
    }

    public String getPiPosition() {
        return piPosition;
    }

    public void setPiPosition(String piPosition) {
        this.piPosition = piPosition == null ? null : piPosition.trim();
    }

    public String getPiYzdw() {
        return piYzdw;
    }

    public void setPiYzdw(String piYzdw) {
        this.piYzdw = piYzdw == null ? null : piYzdw.trim();
    }

    public String getPiCbdw() {
        return piCbdw;
    }

    public void setPiCbdw(String piCbdw) {
        this.piCbdw = piCbdw == null ? null : piCbdw.trim();
    }

    public String getPiSgdw() {
        return piSgdw;
    }

    public void setPiSgdw(String piSgdw) {
        this.piSgdw = piSgdw == null ? null : piSgdw.trim();
    }

    public String getPiAddress() {
        return piAddress;
    }

    public void setPiAddress(String piAddress) {
        this.piAddress = piAddress == null ? null : piAddress.trim();
    }

    public Date getPiOpendate() {
        return piOpendate;
    }

    public void setPiOpendate(Date piOpendate) {
        this.piOpendate = piOpendate;
    }

    public Date getPiColsedate() {
        return piColsedate;
    }

    public void setPiColsedate(Date piColsedate) {
        this.piColsedate = piColsedate;
    }

    public Byte getPiStatus() {
        return piStatus;
    }

    public void setPiStatus(Byte piStatus) {
        this.piStatus = piStatus;
    }

    public Byte getPiFlag() {
        return piFlag;
    }

    public void setPiFlag(Byte piFlag) {
        this.piFlag = piFlag;
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

    public String getPiDesc() {
        return piDesc;
    }

    public void setPiDesc(String piDesc) {
        this.piDesc = piDesc == null ? null : piDesc.trim();
    }
}