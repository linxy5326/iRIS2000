package com.iris.monitor.entity;

import java.util.Date;

public class Iris_Pro_Sec_Line {
    private String id;

    private String sId;

    private String slName;

    private String slSeMileage;

    private String slSePosition;

    private Integer slStartringno;

    private Integer slRingnum;

    private Float slLength;

    private Integer slJhgq;

    private String slPrefix;

    private Date gmtCreate;

    private Date gmtModified;

    private String sInfoid;

    private String slDesc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId == null ? null : sId.trim();
    }

    public String getSlName() {
        return slName;
    }

    public void setSlName(String slName) {
        this.slName = slName == null ? null : slName.trim();
    }

    public String getSlSeMileage() {
        return slSeMileage;
    }

    public void setSlSeMileage(String slSeMileage) {
        this.slSeMileage = slSeMileage == null ? null : slSeMileage.trim();
    }

    public String getSlSePosition() {
        return slSePosition;
    }

    public void setSlSePosition(String slSePosition) {
        this.slSePosition = slSePosition == null ? null : slSePosition.trim();
    }

    public Integer getSlStartringno() {
        return slStartringno;
    }

    public void setSlStartringno(Integer slStartringno) {
        this.slStartringno = slStartringno;
    }

    public Integer getSlRingnum() {
        return slRingnum;
    }

    public void setSlRingnum(Integer slRingnum) {
        this.slRingnum = slRingnum;
    }

    public Float getSlLength() {
        return slLength;
    }

    public void setSlLength(Float slLength) {
        this.slLength = slLength;
    }

    public Integer getSlJhgq() {
        return slJhgq;
    }

    public void setSlJhgq(Integer slJhgq) {
        this.slJhgq = slJhgq;
    }

    public String getSlPrefix() {
        return slPrefix;
    }

    public void setSlPrefix(String slPrefix) {
        this.slPrefix = slPrefix == null ? null : slPrefix.trim();
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

    public String getsInfoid() {
        return sInfoid;
    }

    public void setsInfoid(String sInfoid) {
        this.sInfoid = sInfoid == null ? null : sInfoid.trim();
    }

    public String getSlDesc() {
        return slDesc;
    }

    public void setSlDesc(String slDesc) {
        this.slDesc = slDesc == null ? null : slDesc.trim();
    }
}