package com.iris.monitor.mapper;

import com.iris.monitor.entity.Sys_UserAccount;
import org.apache.ibatis.jdbc.SQL;

public class Sys_UserAccountSqlProvider {

    public String insertSelective(Sys_UserAccount record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_useraccount");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUaName() != null) {
            sql.VALUES("ua_name", "#{uaName,jdbcType=VARCHAR}");
        }
        
        if (record.getUaEmail() != null) {
            sql.VALUES("ua_email", "#{uaEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getUaPwd() != null) {
            sql.VALUES("ua_pwd", "#{uaPwd,jdbcType=VARCHAR}");
        }
        
        if (record.getUaNickname() != null) {
            sql.VALUES("ua_nickname", "#{uaNickname,jdbcType=VARCHAR}");
        }
        
        if (record.getUaStatus() != null) {
            sql.VALUES("ua_status", "#{uaStatus,jdbcType=TINYINT}");
        }
        
        if (record.getUaRegdate() != null) {
            sql.VALUES("ua_regdate", "#{uaRegdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUaExpirydate() != null) {
            sql.VALUES("ua_expirydate", "#{uaExpirydate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUaDesc() != null) {
            sql.VALUES("ua_desc", "#{uaDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getUaGroup() != null) {
            sql.VALUES("ua_group", "#{uaGroup,jdbcType=VARCHAR}");
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
        
        if (record.getuId() != null) {
            sql.VALUES("u_id", "#{uId,jdbcType=INTEGER}");
        }
        
        if (record.getAppId() != null) {
            sql.VALUES("app_id", "#{appId,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Sys_UserAccount record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_useraccount");
        
        if (record.getUaName() != null) {
            sql.SET("ua_name = #{uaName,jdbcType=VARCHAR}");
        }
        
        if (record.getUaEmail() != null) {
            sql.SET("ua_email = #{uaEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getUaPwd() != null) {
            sql.SET("ua_pwd = #{uaPwd,jdbcType=VARCHAR}");
        }
        
        if (record.getUaNickname() != null) {
            sql.SET("ua_nickname = #{uaNickname,jdbcType=VARCHAR}");
        }
        
        if (record.getUaStatus() != null) {
            sql.SET("ua_status = #{uaStatus,jdbcType=TINYINT}");
        }
        
        if (record.getUaRegdate() != null) {
            sql.SET("ua_regdate = #{uaRegdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUaExpirydate() != null) {
            sql.SET("ua_expirydate = #{uaExpirydate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUaDesc() != null) {
            sql.SET("ua_desc = #{uaDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getUaGroup() != null) {
            sql.SET("ua_group = #{uaGroup,jdbcType=VARCHAR}");
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
        
        if (record.getuId() != null) {
            sql.SET("u_id = #{uId,jdbcType=INTEGER}");
        }
        
        if (record.getAppId() != null) {
            sql.SET("app_id = #{appId,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}