package com.iris.monitor.entity;

public class Iris_Ui_B {
    private Integer id;

    private String uibName;

    private String uibUint;

    private String uibDe;

    private Integer uiId;

    private String iopTv;

    private String iopFe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUibName() {
        return uibName;
    }

    public void setUibName(String uibName) {
        this.uibName = uibName == null ? null : uibName.trim();
    }

    public String getUibUint() {
        return uibUint;
    }

    public void setUibUint(String uibUint) {
        this.uibUint = uibUint == null ? null : uibUint.trim();
    }

    public String getUibDe() {
        return uibDe;
    }

    public void setUibDe(String uibDe) {
        this.uibDe = uibDe == null ? null : uibDe.trim();
    }

    public Integer getUiId() {
        return uiId;
    }

    public void setUiId(Integer uiId) {
        this.uiId = uiId;
    }

    public String getIopTv() {
        return iopTv;
    }

    public void setIopTv(String iopTv) {
        this.iopTv = iopTv == null ? null : iopTv.trim();
    }

    public String getIopFe() {
        return iopFe;
    }

    public void setIopFe(String iopFe) {
        this.iopFe = iopFe == null ? null : iopFe.trim();
    }
}