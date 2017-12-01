package com.iris.monitor.entity;

import java.util.Date;

public class Iris_TbmInfo {
    private String id;

    private String tiMno;

    private String tiFno;

    private String tiName;

    private String tiManufacturer;

    private String tiVest;

    private Date tiBuydate;

    private String tiModel;

    private Float tiLength;

    private Float tiDiameter;

    private String tiManfrefixkey;

    private Byte tiType;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDeleted;

    private String orgId;

    private String tiDesc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTiMno() {
        return tiMno;
    }

    public void setTiMno(String tiMno) {
        this.tiMno = tiMno == null ? null : tiMno.trim();
    }

    public String getTiFno() {
        return tiFno;
    }

    public void setTiFno(String tiFno) {
        this.tiFno = tiFno == null ? null : tiFno.trim();
    }

    public String getTiName() {
        return tiName;
    }

    public void setTiName(String tiName) {
        this.tiName = tiName == null ? null : tiName.trim();
    }

    public String getTiManufacturer() {
        return tiManufacturer;
    }

    public void setTiManufacturer(String tiManufacturer) {
        this.tiManufacturer = tiManufacturer == null ? null : tiManufacturer.trim();
    }

    public String getTiVest() {
        return tiVest;
    }

    public void setTiVest(String tiVest) {
        this.tiVest = tiVest == null ? null : tiVest.trim();
    }

    public Date getTiBuydate() {
        return tiBuydate;
    }

    public void setTiBuydate(Date tiBuydate) {
        this.tiBuydate = tiBuydate;
    }

    public String getTiModel() {
        return tiModel;
    }

    public void setTiModel(String tiModel) {
        this.tiModel = tiModel == null ? null : tiModel.trim();
    }

    public Float getTiLength() {
        return tiLength;
    }

    public void setTiLength(Float tiLength) {
        this.tiLength = tiLength;
    }

    public Float getTiDiameter() {
        return tiDiameter;
    }

    public void setTiDiameter(Float tiDiameter) {
        this.tiDiameter = tiDiameter;
    }

    public String getTiManfrefixkey() {
        return tiManfrefixkey;
    }

    public void setTiManfrefixkey(String tiManfrefixkey) {
        this.tiManfrefixkey = tiManfrefixkey == null ? null : tiManfrefixkey.trim();
    }

    public Byte getTiType() {
        return tiType;
    }

    public void setTiType(Byte tiType) {
        this.tiType = tiType;
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

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getTiDesc() {
        return tiDesc;
    }

    public void setTiDesc(String tiDesc) {
        this.tiDesc = tiDesc == null ? null : tiDesc.trim();
    }
}