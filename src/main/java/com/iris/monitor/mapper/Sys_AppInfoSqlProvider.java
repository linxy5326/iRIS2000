package com.iris.monitor.mapper;

import com.iris.monitor.entity.Sys_AppInfo;
import org.apache.ibatis.jdbc.SQL;

public class Sys_AppInfoSqlProvider {

    public String insertSelective(Sys_AppInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_appinfo");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=VARCHAR}");
        }
        
        if (record.getAppName() != null) {
            sql.VALUES("app_name", "#{appName,jdbcType=VARCHAR}");
        }
        
        if (record.getAppVersion() != null) {
            sql.VALUES("app_version", "#{appVersion,jdbcType=VARCHAR}");
        }
        
        if (record.getAppProviderinfo() != null) {
            sql.VALUES("app_providerinfo", "#{appProviderinfo,jdbcType=VARCHAR}");
        }
        
        if (record.getAppRegtime() != null) {
            sql.VALUES("app_regtime", "#{appRegtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAppUrl() != null) {
            sql.VALUES("app_url", "#{appUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getGmtModified() != null) {
            sql.VALUES("gmt_modified", "#{gmtModified,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtCreate() != null) {
            sql.VALUES("gmt_create", "#{gmtCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIsDeleted() != null) {
            sql.VALUES("is_deleted", "#{isDeleted,jdbcType=TINYINT}");
        }
        
        if (record.getAppIocn() != null) {
            sql.VALUES("app_iocn", "#{appIocn,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Sys_AppInfo record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_appinfo");
        
        if (record.getAppName() != null) {
            sql.SET("app_name = #{appName,jdbcType=VARCHAR}");
        }
        
        if (record.getAppVersion() != null) {
            sql.SET("app_version = #{appVersion,jdbcType=VARCHAR}");
        }
        
        if (record.getAppProviderinfo() != null) {
            sql.SET("app_providerinfo = #{appProviderinfo,jdbcType=VARCHAR}");
        }
        
        if (record.getAppRegtime() != null) {
            sql.SET("app_regtime = #{appRegtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAppUrl() != null) {
            sql.SET("app_url = #{appUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getGmtModified() != null) {
            sql.SET("gmt_modified = #{gmtModified,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtCreate() != null) {
            sql.SET("gmt_create = #{gmtCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIsDeleted() != null) {
            sql.SET("is_deleted = #{isDeleted,jdbcType=TINYINT}");
        }
        
        if (record.getAppIocn() != null) {
            sql.SET("app_iocn = #{appIocn,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=VARCHAR}");
        
        return sql.toString();
    }
}