package com.iris.monitor.entity;

public class Iris_Ui_IoMap {
    private Integer id;

    private Integer uibId;

    private Integer iriId;

    private String uiopDv;

    private String uiopName;

    private String uiopFe;

    private String uiopTv;

    private String uiopNum;

    private Byte uiopIsshow;

    private String uiopUnit;

    private Integer uiBid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUibId() {
        return uibId;
    }

    public void setUibId(Integer uibId) {
        this.uibId = uibId;
    }

    public Integer getIriId() {
        return iriId;
    }

    public void setIriId(Integer iriId) {
        this.iriId = iriId;
    }

    public String getUiopDv() {
        return uiopDv;
    }

    public void setUiopDv(String uiopDv) {
        this.uiopDv = uiopDv == null ? null : uiopDv.trim();
    }

    public String getUiopName() {
        return uiopName;
    }

    public void setUiopName(String uiopName) {
        this.uiopName = uiopName == null ? null : uiopName.trim();
    }

    public String getUiopFe() {
        return uiopFe;
    }

    public void setUiopFe(String uiopFe) {
        this.uiopFe = uiopFe == null ? null : uiopFe.trim();
    }

    public String getUiopTv() {
        return uiopTv;
    }

    public void setUiopTv(String uiopTv) {
        this.uiopTv = uiopTv == null ? null : uiopTv.trim();
    }

    public String getUiopNum() {
        return uiopNum;
    }

    public void setUiopNum(String uiopNum) {
        this.uiopNum = uiopNum == null ? null : uiopNum.trim();
    }

    public Byte getUiopIsshow() {
        return uiopIsshow;
    }

    public void setUiopIsshow(Byte uiopIsshow) {
        this.uiopIsshow = uiopIsshow;
    }

    public String getUiopUnit() {
        return uiopUnit;
    }

    public void setUiopUnit(String uiopUnit) {
        this.uiopUnit = uiopUnit == null ? null : uiopUnit.trim();
    }

    public Integer getUiBid() {
        return uiBid;
    }

    public void setUiBid(Integer uiBid) {
        this.uiBid = uiBid;
    }
}