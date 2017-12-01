package com.iris.monitor.mapper;

import com.iris.monitor.entity.Sys_OrganizationInfo;
import org.apache.ibatis.jdbc.SQL;

public class Sys_OrganizationInfoSqlProvider {

    public String insertSelective(Sys_OrganizationInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_organizationinfo");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=VARCHAR}");
        }
        
        if (record.getAppId() != null) {
            sql.VALUES("app_id", "#{appId,jdbcType=VARCHAR}");
        }
        
        if (record.getOrgName() != null) {
            sql.VALUES("org_name", "#{orgName,jdbcType=VARCHAR}");
        }
        
        if (record.getOrgCode() != null) {
            sql.VALUES("org_code", "#{orgCode,jdbcType=VARCHAR}");
        }
        
        if (record.getOrgParent() != null) {
            sql.VALUES("org_parent", "#{orgParent,jdbcType=VARCHAR}");
        }
        
        if (record.getOrgIndexcode() != null) {
            sql.VALUES("org_indexcode", "#{orgIndexcode,jdbcType=VARCHAR}");
        }
        
        if (record.getOrgAddress() != null) {
            sql.VALUES("org_address", "#{orgAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getOrgType() != null) {
            sql.VALUES("org_type", "#{orgType,jdbcType=TINYINT}");
        }
        
        if (record.getOrgStatus() != null) {
            sql.VALUES("org_status", "#{orgStatus,jdbcType=TINYINT}");
        }
        
        if (record.getIsDeleted() != null) {
            sql.VALUES("is_deleted", "#{isDeleted,jdbcType=TINYINT}");
        }
        
        if (record.getGmtCreate() != null) {
            sql.VALUES("gmt_create", "#{gmtCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtModified() != null) {
            sql.VALUES("gmt_modified", "#{gmtModified,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOrgJianjie() != null) {
            sql.VALUES("org_jianjie", "#{orgJianjie,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Sys_OrganizationInfo record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_organizationinfo");
        
        if (record.getAppId() != null) {
            sql.SET("app_id = #{appId,jdbcType=VARCHAR}");
        }
        
        if (record.getOrgName() != null) {
            sql.SET("org_name = #{orgName,jdbcType=VARCHAR}");
        }
        
        if (record.getOrgCode() != null) {
            sql.SET("org_code = #{orgCode,jdbcType=VARCHAR}");
        }
        
        if (record.getOrgParent() != null) {
            sql.SET("org_parent = #{orgParent,jdbcType=VARCHAR}");
        }
        
        if (record.getOrgIndexcode() != null) {
            sql.SET("org_indexcode = #{orgIndexcode,jdbcType=VARCHAR}");
        }
        
        if (record.getOrgAddress() != null) {
            sql.SET("org_address = #{orgAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getOrgType() != null) {
            sql.SET("org_type = #{orgType,jdbcType=TINYINT}");
        }
        
        if (record.getOrgStatus() != null) {
            sql.SET("org_status = #{orgStatus,jdbcType=TINYINT}");
        }
        
        if (record.getIsDeleted() != null) {
            sql.SET("is_deleted = #{isDeleted,jdbcType=TINYINT}");
        }
        
        if (record.getGmtCreate() != null) {
            sql.SET("gmt_create = #{gmtCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtModified() != null) {
            sql.SET("gmt_modified = #{gmtModified,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOrgJianjie() != null) {
            sql.SET("org_jianjie = #{orgJianjie,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=VARCHAR}");
        
        return sql.toString();
    }
}