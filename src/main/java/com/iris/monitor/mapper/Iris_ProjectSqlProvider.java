package com.iris.monitor.mapper;

import com.iris.monitor.entity.Iris_Project;
import org.apache.ibatis.jdbc.SQL;

public class Iris_ProjectSqlProvider {

    public String insertSelective(Iris_Project record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("iris_project");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=CHAR}");
        }
        
        if (record.getOrgId() != null) {
            sql.VALUES("org_id", "#{orgId,jdbcType=VARCHAR}");
        }
        
        if (record.getPiPmcode() != null) {
            sql.VALUES("pi_pmcode", "#{piPmcode,jdbcType=VARCHAR}");
        }
        
        if (record.getPiName() != null) {
            sql.VALUES("pi_name", "#{piName,jdbcType=VARCHAR}");
        }
        
        if (record.getPiProvince() != null) {
            sql.VALUES("pi_province", "#{piProvince,jdbcType=VARCHAR}");
        }
        
        if (record.getPiPosition() != null) {
            sql.VALUES("pi_position", "#{piPosition,jdbcType=VARCHAR}");
        }
        
        if (record.getPiYzdw() != null) {
            sql.VALUES("pi_yzdw", "#{piYzdw,jdbcType=VARCHAR}");
        }
        
        if (record.getPiCbdw() != null) {
            sql.VALUES("pi_cbdw", "#{piCbdw,jdbcType=VARCHAR}");
        }
        
        if (record.getPiSgdw() != null) {
            sql.VALUES("pi_sgdw", "#{piSgdw,jdbcType=VARCHAR}");
        }
        
        if (record.getPiAddress() != null) {
            sql.VALUES("pi_address", "#{piAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getPiOpendate() != null) {
            sql.VALUES("pi_opendate", "#{piOpendate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPiColsedate() != null) {
            sql.VALUES("pi_colsedate", "#{piColsedate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPiStatus() != null) {
            sql.VALUES("pi_status", "#{piStatus,jdbcType=TINYINT}");
        }
        
        if (record.getPiFlag() != null) {
            sql.VALUES("pi_flag", "#{piFlag,jdbcType=TINYINT}");
        }
        
        if (record.getGmtCreate() != null) {
            sql.VALUES("gmt_create", "#{gmtCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtModified() != null) {
            sql.VALUES("gmt_modified", "#{gmtModified,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIsDeleted() != null) {
            sql.VALUES("is_deleted", "#{isDeleted,jdbcType=TINYINT}");
        }
        
        if (record.getPiDesc() != null) {
            sql.VALUES("pi_desc", "#{piDesc,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Iris_Project record) {
        SQL sql = new SQL();
        sql.UPDATE("iris_project");
        
        if (record.getOrgId() != null) {
            sql.SET("org_id = #{orgId,jdbcType=VARCHAR}");
        }
        
        if (record.getPiPmcode() != null) {
            sql.SET("pi_pmcode = #{piPmcode,jdbcType=VARCHAR}");
        }
        
        if (record.getPiName() != null) {
            sql.SET("pi_name = #{piName,jdbcType=VARCHAR}");
        }
        
        if (record.getPiProvince() != null) {
            sql.SET("pi_province = #{piProvince,jdbcType=VARCHAR}");
        }
        
        if (record.getPiPosition() != null) {
            sql.SET("pi_position = #{piPosition,jdbcType=VARCHAR}");
        }
        
        if (record.getPiYzdw() != null) {
            sql.SET("pi_yzdw = #{piYzdw,jdbcType=VARCHAR}");
        }
        
        if (record.getPiCbdw() != null) {
            sql.SET("pi_cbdw = #{piCbdw,jdbcType=VARCHAR}");
        }
        
        if (record.getPiSgdw() != null) {
            sql.SET("pi_sgdw = #{piSgdw,jdbcType=VARCHAR}");
        }
        
        if (record.getPiAddress() != null) {
            sql.SET("pi_address = #{piAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getPiOpendate() != null) {
            sql.SET("pi_opendate = #{piOpendate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPiColsedate() != null) {
            sql.SET("pi_colsedate = #{piColsedate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPiStatus() != null) {
            sql.SET("pi_status = #{piStatus,jdbcType=TINYINT}");
        }
        
        if (record.getPiFlag() != null) {
            sql.SET("pi_flag = #{piFlag,jdbcType=TINYINT}");
        }
        
        if (record.getGmtCreate() != null) {
            sql.SET("gmt_create = #{gmtCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtModified() != null) {
            sql.SET("gmt_modified = #{gmtModified,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIsDeleted() != null) {
            sql.SET("is_deleted = #{isDeleted,jdbcType=TINYINT}");
        }
        
        if (record.getPiDesc() != null) {
            sql.SET("pi_desc = #{piDesc,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=CHAR}");
        
        return sql.toString();
    }
}