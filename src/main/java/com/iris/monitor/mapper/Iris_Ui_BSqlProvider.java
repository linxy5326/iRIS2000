package com.iris.monitor.mapper;

import com.iris.monitor.entity.Iris_Ui_B;
import org.apache.ibatis.jdbc.SQL;

public class Iris_Ui_BSqlProvider {

    public String insertSelective(Iris_Ui_B record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("iris_ui_b");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUibName() != null) {
            sql.VALUES("uib_name", "#{uibName,jdbcType=VARCHAR}");
        }
        
        if (record.getUibUint() != null) {
            sql.VALUES("uib_uint", "#{uibUint,jdbcType=VARCHAR}");
        }
        
        if (record.getUibDe() != null) {
            sql.VALUES("uib_de", "#{uibDe,jdbcType=VARCHAR}");
        }
        
        if (record.getUiId() != null) {
            sql.VALUES("ui_id", "#{uiId,jdbcType=INTEGER}");
        }
        
        if (record.getIopTv() != null) {
            sql.VALUES("iop_tv", "#{iopTv,jdbcType=VARCHAR}");
        }
        
        if (record.getIopFe() != null) {
            sql.VALUES("iop_fe", "#{iopFe,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Iris_Ui_B record) {
        SQL sql = new SQL();
        sql.UPDATE("iris_ui_b");
        
        if (record.getUibName() != null) {
            sql.SET("uib_name = #{uibName,jdbcType=VARCHAR}");
        }
        
        if (record.getUibUint() != null) {
            sql.SET("uib_uint = #{uibUint,jdbcType=VARCHAR}");
        }
        
        if (record.getUibDe() != null) {
            sql.SET("uib_de = #{uibDe,jdbcType=VARCHAR}");
        }
        
        if (record.getUiId() != null) {
            sql.SET("ui_id = #{uiId,jdbcType=INTEGER}");
        }
        
        if (record.getIopTv() != null) {
            sql.SET("iop_tv = #{iopTv,jdbcType=VARCHAR}");
        }
        
        if (record.getIopFe() != null) {
            sql.SET("iop_fe = #{iopFe,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}