package com.iris.monitor.mapper;

import com.iris.monitor.entity.Iris_Ici_Ui;
import org.apache.ibatis.jdbc.SQL;

public class Iris_Ici_UiSqlProvider {

    public String insertSelective(Iris_Ici_Ui record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("iris_ici_ui");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUiName() != null) {
            sql.VALUES("ui_name", "#{uiName,jdbcType=VARCHAR}");
        }
        
        if (record.getUiPath() != null) {
            sql.VALUES("ui_path", "#{uiPath,jdbcType=VARCHAR}");
        }
        
        if (record.getUiIndex() != null) {
            sql.VALUES("ui_index", "#{uiIndex,jdbcType=INTEGER}");
        }
        
        if (record.getUiDesc() != null) {
            sql.VALUES("ui_desc", "#{uiDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getUiEnabled() != null) {
            sql.VALUES("ui_enabled", "#{uiEnabled,jdbcType=TINYINT}");
        }
        
        if (record.getGmtCerate() != null) {
            sql.VALUES("gmt_cerate", "#{gmtCerate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtModified() != null) {
            sql.VALUES("gmt_modified", "#{gmtModified,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIsDeleted() != null) {
            sql.VALUES("is_deleted", "#{isDeleted,jdbcType=TINYINT}");
        }
        
        if (record.getUiVisible() != null) {
            sql.VALUES("ui_visible", "#{uiVisible,jdbcType=TINYINT}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Iris_Ici_Ui record) {
        SQL sql = new SQL();
        sql.UPDATE("iris_ici_ui");
        
        if (record.getUiName() != null) {
            sql.SET("ui_name = #{uiName,jdbcType=VARCHAR}");
        }
        
        if (record.getUiPath() != null) {
            sql.SET("ui_path = #{uiPath,jdbcType=VARCHAR}");
        }
        
        if (record.getUiIndex() != null) {
            sql.SET("ui_index = #{uiIndex,jdbcType=INTEGER}");
        }
        
        if (record.getUiDesc() != null) {
            sql.SET("ui_desc = #{uiDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getUiEnabled() != null) {
            sql.SET("ui_enabled = #{uiEnabled,jdbcType=TINYINT}");
        }
        
        if (record.getGmtCerate() != null) {
            sql.SET("gmt_cerate = #{gmtCerate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtModified() != null) {
            sql.SET("gmt_modified = #{gmtModified,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIsDeleted() != null) {
            sql.SET("is_deleted = #{isDeleted,jdbcType=TINYINT}");
        }
        
        if (record.getUiVisible() != null) {
            sql.SET("ui_visible = #{uiVisible,jdbcType=TINYINT}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}