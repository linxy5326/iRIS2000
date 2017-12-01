package com.iris.monitor.entity;

import java.util.Date;

public class Iris_Line_Tbm {
    private Integer id;

    private String iriId;

    private String iriId2;

    private String ltCode;

    private Date ltSfdate;

    private Date ltGtdate;

    private Integer ltSggq;

    private Date ltIndate;

    private Date ltOutdate;

    private Date gmtCreate;

    private Date gmtModified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIriId() {
        return iriId;
    }

    public void setIriId(String iriId) {
        this.iriId = iriId == null ? null : iriId.trim();
    }

    public String getIriId2() {
        return iriId2;
    }

    public void setIriId2(String iriId2) {
        this.iriId2 = iriId2 == null ? null : iriId2.trim();
    }

    public String getLtCode() {
        return ltCode;
    }

    public void setLtCode(String ltCode) {
        this.ltCode = ltCode == null ? null : ltCode.trim();
    }

    public Date getLtSfdate() {
        return ltSfdate;
    }

    public void setLtSfdate(Date ltSfdate) {
        this.ltSfdate = ltSfdate;
    }

    public Date getLtGtdate() {
        return ltGtdate;
    }

    public void setLtGtdate(Date ltGtdate) {
        this.ltGtdate = ltGtdate;
    }

    public Integer getLtSggq() {
        return ltSggq;
    }

    public void setLtSggq(Integer ltSggq) {
        this.ltSggq = ltSggq;
    }

    public Date getLtIndate() {
        return ltIndate;
    }

    public void setLtIndate(Date ltIndate) {
        this.ltIndate = ltIndate;
    }

    public Date getLtOutdate() {
        return ltOutdate;
    }

    public void setLtOutdate(Date ltOutdate) {
        this.ltOutdate = ltOutdate;
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
}