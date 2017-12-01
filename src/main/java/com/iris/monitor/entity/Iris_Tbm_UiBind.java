package com.iris.monitor.entity;

public class Iris_Tbm_UiBind {
    private Integer id;

    private String iriId;

    private Integer tubSort;

    private String tubName;

    private Integer uiId;

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

    public Integer getTubSort() {
        return tubSort;
    }

    public void setTubSort(Integer tubSort) {
        this.tubSort = tubSort;
    }

    public String getTubName() {
        return tubName;
    }

    public void setTubName(String tubName) {
        this.tubName = tubName == null ? null : tubName.trim();
    }

    public Integer getUiId() {
        return uiId;
    }

    public void setUiId(Integer uiId) {
        this.uiId = uiId;
    }
}