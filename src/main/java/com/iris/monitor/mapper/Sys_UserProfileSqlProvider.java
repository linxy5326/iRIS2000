package com.iris.monitor.mapper;

import com.iris.monitor.entity.Sys_UserProfile;
import org.apache.ibatis.jdbc.SQL;

public class Sys_UserProfileSqlProvider {

    public String insertSelective(Sys_UserProfile record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_userprofile");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getGmtCreate() != null) {
            sql.VALUES("gmt_create", "#{gmtCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtModified() != null) {
            sql.VALUES("gmt_modified", "#{gmtModified,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUaId() != null) {
            sql.VALUES("ua_id", "#{uaId,jdbcType=INTEGER}");
        }
        
        if (record.getPfData() != null) {
            sql.VALUES("pf_data", "#{pfData,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Sys_UserProfile record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_userprofile");
        
        if (record.getGmtCreate() != null) {
            sql.SET("gmt_create = #{gmtCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtModified() != null) {
            sql.SET("gmt_modified = #{gmtModified,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUaId() != null) {
            sql.SET("ua_id = #{uaId,jdbcType=INTEGER}");
        }
        
        if (record.getPfData() != null) {
            sql.SET("pf_data = #{pfData,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}