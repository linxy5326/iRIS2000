package com.iris.monitor.mapper;

import com.iris.monitor.entity.Iris_TbmInfo;
import org.apache.ibatis.jdbc.SQL;

public class Iris_TbmInfoSqlProvider {

    public String insertSelective(Iris_TbmInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("iris_tbminfo");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=CHAR}");
        }
        
        if (record.getTiMno() != null) {
            sql.VALUES("ti_mno", "#{tiMno,jdbcType=VARCHAR}");
        }
        
        if (record.getTiFno() != null) {
            sql.VALUES("ti_fno", "#{tiFno,jdbcType=VARCHAR}");
        }
        
        if (record.getTiName() != null) {
            sql.VALUES("ti_name", "#{tiName,jdbcType=VARCHAR}");
        }
        
        if (record.getTiManufacturer() != null) {
            sql.VALUES("ti_manufacturer", "#{tiManufacturer,jdbcType=VARCHAR}");
        }
        
        if (record.getTiVest() != null) {
            sql.VALUES("ti_vest", "#{tiVest,jdbcType=VARCHAR}");
        }
        
        if (record.getTiBuydate() != null) {
            sql.VALUES("ti_buydate", "#{tiBuydate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTiModel() != null) {
            sql.VALUES("ti_model", "#{tiModel,jdbcType=VARCHAR}");
        }
        
        if (record.getTiLength() != null) {
            sql.VALUES("ti_length", "#{tiLength,jdbcType=REAL}");
        }
        
        if (record.getTiDiameter() != null) {
            sql.VALUES("ti_diameter", "#{tiDiameter,jdbcType=REAL}");
        }
        
        if (record.getTiManfrefixkey() != null) {
            sql.VALUES("ti_manfrefixkey", "#{tiManfrefixkey,jdbcType=VARCHAR}");
        }
        
        if (record.getTiType() != null) {
            sql.VALUES("ti_type", "#{tiType,jdbcType=TINYINT}");
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
        
        if (record.getOrgId() != null) {
            sql.VALUES("org_id", "#{orgId,jdbcType=VARCHAR}");
        }
        
        if (record.getTiDesc() != null) {
            sql.VALUES("ti_desc", "#{tiDesc,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Iris_TbmInfo record) {
        SQL sql = new SQL();
        sql.UPDATE("iris_tbminfo");
        
        if (record.getTiMno() != null) {
            sql.SET("ti_mno = #{tiMno,jdbcType=VARCHAR}");
        }
        
        if (record.getTiFno() != null) {
            sql.SET("ti_fno = #{tiFno,jdbcType=VARCHAR}");
        }
        
        if (record.getTiName() != null) {
            sql.SET("ti_name = #{tiName,jdbcType=VARCHAR}");
        }
        
        if (record.getTiManufacturer() != null) {
            sql.SET("ti_manufacturer = #{tiManufacturer,jdbcType=VARCHAR}");
        }
        
        if (record.getTiVest() != null) {
            sql.SET("ti_vest = #{tiVest,jdbcType=VARCHAR}");
        }
        
        if (record.getTiBuydate() != null) {
            sql.SET("ti_buydate = #{tiBuydate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTiModel() != null) {
            sql.SET("ti_model = #{tiModel,jdbcType=VARCHAR}");
        }
        
        if (record.getTiLength() != null) {
            sql.SET("ti_length = #{tiLength,jdbcType=REAL}");
        }
        
        if (record.getTiDiameter() != null) {
            sql.SET("ti_diameter = #{tiDiameter,jdbcType=REAL}");
        }
        
        if (record.getTiManfrefixkey() != null) {
            sql.SET("ti_manfrefixkey = #{tiManfrefixkey,jdbcType=VARCHAR}");
        }
        
        if (record.getTiType() != null) {
            sql.SET("ti_type = #{tiType,jdbcType=TINYINT}");
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
        
        if (record.getOrgId() != null) {
            sql.SET("org_id = #{orgId,jdbcType=VARCHAR}");
        }
        
        if (record.getTiDesc() != null) {
            sql.SET("ti_desc = #{tiDesc,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=CHAR}");
        
        return sql.toString();
    }
}