package com.iris.monitor.mapper;

import com.iris.monitor.entity.Iris_Tbm_UiBind;
import org.apache.ibatis.jdbc.SQL;

public class Iris_Tbm_UiBindSqlProvider {

    public String insertSelective(Iris_Tbm_UiBind record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("iris_tbm_uibind");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getIriId() != null) {
            sql.VALUES("iri_id", "#{iriId,jdbcType=CHAR}");
        }
        
        if (record.getTubSort() != null) {
            sql.VALUES("tub_sort", "#{tubSort,jdbcType=INTEGER}");
        }
        
        if (record.getTubName() != null) {
            sql.VALUES("tub_name", "#{tubName,jdbcType=VARCHAR}");
        }
        
        if (record.getUiId() != null) {
            sql.VALUES("ui_id", "#{uiId,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Iris_Tbm_UiBind record) {
        SQL sql = new SQL();
        sql.UPDATE("iris_tbm_uibind");
        
        if (record.getIriId() != null) {
            sql.SET("iri_id = #{iriId,jdbcType=CHAR}");
        }
        
        if (record.getTubSort() != null) {
            sql.SET("tub_sort = #{tubSort,jdbcType=INTEGER}");
        }
        
        if (record.getTubName() != null) {
            sql.SET("tub_name = #{tubName,jdbcType=VARCHAR}");
        }
        
        if (record.getUiId() != null) {
            sql.SET("ui_id = #{uiId,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}