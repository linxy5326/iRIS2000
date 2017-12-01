package com.iris.monitor.mapper;

import com.iris.monitor.entity.Sys_ResourceInfo;
import org.apache.ibatis.jdbc.SQL;

public class Sys_ResourceInfoSqlProvider {

    public String insertSelective(Sys_ResourceInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_resourceinfo");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getAppId() != null) {
            sql.VALUES("app_id", "#{appId,jdbcType=VARCHAR}");
        }
        
        if (record.getRiName() != null) {
            sql.VALUES("ri_name", "#{riName,jdbcType=VARCHAR}");
        }
        
        if (record.getRiPath() != null) {
            sql.VALUES("ri_path", "#{riPath,jdbcType=VARCHAR}");
        }
        
        if (record.getRiPkgname() != null) {
            sql.VALUES("ri_pkgname", "#{riPkgname,jdbcType=VARCHAR}");
        }
        
        if (record.getRiType() != null) {
            sql.VALUES("ri_type", "#{riType,jdbcType=TINYINT}");
        }
        
        if (record.getRiCode() != null) {
            sql.VALUES("ri_code", "#{riCode,jdbcType=VARCHAR}");
        }
        
        if (record.getRiDesc() != null) {
            sql.VALUES("ri_desc", "#{riDesc,jdbcType=VARCHAR}");
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
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Sys_ResourceInfo record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_resourceinfo");
        
        if (record.getAppId() != null) {
            sql.SET("app_id = #{appId,jdbcType=VARCHAR}");
        }
        
        if (record.getRiName() != null) {
            sql.SET("ri_name = #{riName,jdbcType=VARCHAR}");
        }
        
        if (record.getRiPath() != null) {
            sql.SET("ri_path = #{riPath,jdbcType=VARCHAR}");
        }
        
        if (record.getRiPkgname() != null) {
            sql.SET("ri_pkgname = #{riPkgname,jdbcType=VARCHAR}");
        }
        
        if (record.getRiType() != null) {
            sql.SET("ri_type = #{riType,jdbcType=TINYINT}");
        }
        
        if (record.getRiCode() != null) {
            sql.SET("ri_code = #{riCode,jdbcType=VARCHAR}");
        }
        
        if (record.getRiDesc() != null) {
            sql.SET("ri_desc = #{riDesc,jdbcType=VARCHAR}");
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
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}