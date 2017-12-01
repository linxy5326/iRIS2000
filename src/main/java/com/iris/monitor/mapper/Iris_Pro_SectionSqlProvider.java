package com.iris.monitor.mapper;

import com.iris.monitor.entity.Iris_Pro_Section;
import org.apache.ibatis.jdbc.SQL;

public class Iris_Pro_SectionSqlProvider {

    public String insertSelective(Iris_Pro_Section record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("iris_pro_section");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=CHAR}");
        }
        
        if (record.getPsName() != null) {
            sql.VALUES("ps_name", "#{psName,jdbcType=VARCHAR}");
        }
        
        if (record.getPsSectionlen() != null) {
            sql.VALUES("ps_sectionlen", "#{psSectionlen,jdbcType=REAL}");
        }
        
        if (record.getPsSeLoc() != null) {
            sql.VALUES("ps_se_loc", "#{psSeLoc,jdbcType=VARCHAR}");
        }
        
        if (record.getPsSeMileage() != null) {
            sql.VALUES("ps_se_mileage", "#{psSeMileage,jdbcType=VARCHAR}");
        }
        
        if (record.getPsLinecount() != null) {
            sql.VALUES("ps_linecount", "#{psLinecount,jdbcType=INTEGER}");
        }
        
        if (record.getGmtCreate() != null) {
            sql.VALUES("gmt_create", "#{gmtCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtModified() != null) {
            sql.VALUES("gmt_modified", "#{gmtModified,jdbcType=TIMESTAMP}");
        }
        
        if (record.getProId() != null) {
            sql.VALUES("pro_id", "#{proId,jdbcType=CHAR}");
        }
        
        if (record.getPsDesc() != null) {
            sql.VALUES("ps_desc", "#{psDesc,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Iris_Pro_Section record) {
        SQL sql = new SQL();
        sql.UPDATE("iris_pro_section");
        
        if (record.getPsName() != null) {
            sql.SET("ps_name = #{psName,jdbcType=VARCHAR}");
        }
        
        if (record.getPsSectionlen() != null) {
            sql.SET("ps_sectionlen = #{psSectionlen,jdbcType=REAL}");
        }
        
        if (record.getPsSeLoc() != null) {
            sql.SET("ps_se_loc = #{psSeLoc,jdbcType=VARCHAR}");
        }
        
        if (record.getPsSeMileage() != null) {
            sql.SET("ps_se_mileage = #{psSeMileage,jdbcType=VARCHAR}");
        }
        
        if (record.getPsLinecount() != null) {
            sql.SET("ps_linecount = #{psLinecount,jdbcType=INTEGER}");
        }
        
        if (record.getGmtCreate() != null) {
            sql.SET("gmt_create = #{gmtCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtModified() != null) {
            sql.SET("gmt_modified = #{gmtModified,jdbcType=TIMESTAMP}");
        }
        
        if (record.getProId() != null) {
            sql.SET("pro_id = #{proId,jdbcType=CHAR}");
        }
        
        if (record.getPsDesc() != null) {
            sql.SET("ps_desc = #{psDesc,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=CHAR}");
        
        return sql.toString();
    }
}