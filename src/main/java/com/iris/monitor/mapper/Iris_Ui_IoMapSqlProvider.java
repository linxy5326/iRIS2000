package com.iris.monitor.mapper;

import com.iris.monitor.entity.Iris_Ui_IoMap;
import org.apache.ibatis.jdbc.SQL;

public class Iris_Ui_IoMapSqlProvider {

    public String insertSelective(Iris_Ui_IoMap record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("iris_ui_iomap");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUibId() != null) {
            sql.VALUES("uib_id", "#{uibId,jdbcType=INTEGER}");
        }
        
        if (record.getIriId() != null) {
            sql.VALUES("iri_id", "#{iriId,jdbcType=INTEGER}");
        }
        
        if (record.getUiopDv() != null) {
            sql.VALUES("uiop_dv", "#{uiopDv,jdbcType=VARCHAR}");
        }
        
        if (record.getUiopName() != null) {
            sql.VALUES("uiop_name", "#{uiopName,jdbcType=VARCHAR}");
        }
        
        if (record.getUiopFe() != null) {
            sql.VALUES("uiop_fe", "#{uiopFe,jdbcType=VARCHAR}");
        }
        
        if (record.getUiopTv() != null) {
            sql.VALUES("uiop_tv", "#{uiopTv,jdbcType=VARCHAR}");
        }
        
        if (record.getUiopNum() != null) {
            sql.VALUES("uiop_num", "#{uiopNum,jdbcType=VARCHAR}");
        }
        
        if (record.getUiopIsshow() != null) {
            sql.VALUES("uiop_isshow", "#{uiopIsshow,jdbcType=TINYINT}");
        }
        
        if (record.getUiopUnit() != null) {
            sql.VALUES("uiop_unit", "#{uiopUnit,jdbcType=VARCHAR}");
        }
        
        if (record.getUiBid() != null) {
            sql.VALUES("ui_bid", "#{uiBid,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Iris_Ui_IoMap record) {
        SQL sql = new SQL();
        sql.UPDATE("iris_ui_iomap");
        
        if (record.getUibId() != null) {
            sql.SET("uib_id = #{uibId,jdbcType=INTEGER}");
        }
        
        if (record.getIriId() != null) {
            sql.SET("iri_id = #{iriId,jdbcType=INTEGER}");
        }
        
        if (record.getUiopDv() != null) {
            sql.SET("uiop_dv = #{uiopDv,jdbcType=VARCHAR}");
        }
        
        if (record.getUiopName() != null) {
            sql.SET("uiop_name = #{uiopName,jdbcType=VARCHAR}");
        }
        
        if (record.getUiopFe() != null) {
            sql.SET("uiop_fe = #{uiopFe,jdbcType=VARCHAR}");
        }
        
        if (record.getUiopTv() != null) {
            sql.SET("uiop_tv = #{uiopTv,jdbcType=VARCHAR}");
        }
        
        if (record.getUiopNum() != null) {
            sql.SET("uiop_num = #{uiopNum,jdbcType=VARCHAR}");
        }
        
        if (record.getUiopIsshow() != null) {
            sql.SET("uiop_isshow = #{uiopIsshow,jdbcType=TINYINT}");
        }
        
        if (record.getUiopUnit() != null) {
            sql.SET("uiop_unit = #{uiopUnit,jdbcType=VARCHAR}");
        }
        
        if (record.getUiBid() != null) {
            sql.SET("ui_bid = #{uiBid,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}