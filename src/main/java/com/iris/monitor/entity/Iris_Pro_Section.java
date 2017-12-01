package com.iris.monitor.entity;

import java.util.Date;

public class Iris_Pro_Section {
    private String id;

    private String psName;

    private Float psSectionlen;

    private String psSeLoc;

    private String psSeMileage;

    private Integer psLinecount;

    private Date gmtCreate;

    private Date gmtModified;

    private String proId;

    private String psDesc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPsName() {
        return psName;
    }

    public void setPsName(String psName) {
        this.psName = psName == null ? null : psName.trim();
    }

    public Float getPsSectionlen() {
        return psSectionlen;
    }

    public void setPsSectionlen(Float psSectionlen) {
        this.psSectionlen = psSectionlen;
    }

    public String getPsSeLoc() {
        return psSeLoc;
    }

    public void setPsSeLoc(String psSeLoc) {
        this.psSeLoc = psSeLoc == null ? null : psSeLoc.trim();
    }

    public String getPsSeMileage() {
        return psSeMileage;
    }

    public void setPsSeMileage(String psSeMileage) {
        this.psSeMileage = psSeMileage == null ? null : psSeMileage.trim();
    }

    public Integer getPsLinecount() {
        return psLinecount;
    }

    public void setPsLinecount(Integer psLinecount) {
        this.psLinecount = psLinecount;
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

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId == null ? null : proId.trim();
    }

    public String getPsDesc() {
        return psDesc;
    }

    public void setPsDesc(String psDesc) {
        this.psDesc = psDesc == null ? null : psDesc.trim();
    }
}