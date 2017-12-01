package com.iris.monitor.mapper;

import com.iris.monitor.entity.Iris_Tbm_ParkPosition;
import org.apache.ibatis.jdbc.SQL;

public class Iris_Tbm_ParkPositionSqlProvider {

    public String insertSelective(Iris_Tbm_ParkPosition record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("iris_tbm_parkposition");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getTpkAddress() != null) {
            sql.VALUES("tpk_address", "#{tpkAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getTpkName() != null) {
            sql.VALUES("tpk_name", "#{tpkName,jdbcType=VARCHAR}");
        }
        
        if (record.getTpkPosition() != null) {
            sql.VALUES("tpk_position", "#{tpkPosition,jdbcType=VARCHAR}");
        }
        
        if (record.getGmtCreate() != null) {
            sql.VALUES("gmt_create", "#{gmtCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtModified() != null) {
            sql.VALUES("gmt_modified", "#{gmtModified,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTpkDesc() != null) {
            sql.VALUES("tpk_desc", "#{tpkDesc,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Iris_Tbm_ParkPosition record) {
        SQL sql = new SQL();
        sql.UPDATE("iris_tbm_parkposition");
        
        if (record.getTpkAddress() != null) {
            sql.SET("tpk_address = #{tpkAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getTpkName() != null) {
            sql.SET("tpk_name = #{tpkName,jdbcType=VARCHAR}");
        }
        
        if (record.getTpkPosition() != null) {
            sql.SET("tpk_position = #{tpkPosition,jdbcType=VARCHAR}");
        }
        
        if (record.getGmtCreate() != null) {
            sql.SET("gmt_create = #{gmtCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtModified() != null) {
            sql.SET("gmt_modified = #{gmtModified,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTpkDesc() != null) {
            sql.SET("tpk_desc = #{tpkDesc,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}