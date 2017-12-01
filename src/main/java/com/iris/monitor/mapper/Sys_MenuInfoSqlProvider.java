package com.iris.monitor.mapper;

import com.iris.monitor.entity.Sys_MenuInfo;
import org.apache.ibatis.jdbc.SQL;

public class Sys_MenuInfoSqlProvider {

    public String insertSelective(Sys_MenuInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_menuinfo");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getmName() != null) {
            sql.VALUES("m_name", "#{mName,jdbcType=VARCHAR}");
        }
        
        if (record.getmAkey() != null) {
            sql.VALUES("m_akey", "#{mAkey,jdbcType=VARCHAR}");
        }
        
        if (record.getmCode() != null) {
            sql.VALUES("m_code", "#{mCode,jdbcType=VARCHAR}");
        }
        
        if (record.getmOrdernum() != null) {
            sql.VALUES("m_ordernum", "#{mOrdernum,jdbcType=REAL}");
        }
        
        if (record.getrId() != null) {
            sql.VALUES("r_id", "#{rId,jdbcType=INTEGER}");
        }
        
        if (record.getAppId() != null) {
            sql.VALUES("app_id", "#{appId,jdbcType=VARCHAR}");
        }
        
        if (record.getmIcon() != null) {
            sql.VALUES("m_icon", "#{mIcon,jdbcType=VARCHAR}");
        }
        
        if (record.getmIsenabeld() != null) {
            sql.VALUES("m_isenabeld", "#{mIsenabeld,jdbcType=TINYINT}");
        }
        
        if (record.getmIsshow() != null) {
            sql.VALUES("m_isshow", "#{mIsshow,jdbcType=TINYINT}");
        }
        
        if (record.getmParent() != null) {
            sql.VALUES("m_parent", "#{mParent,jdbcType=INTEGER}");
        }
        
        if (record.getmUrl() != null) {
            sql.VALUES("m_url", "#{mUrl,jdbcType=TIMESTAMP}");
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

    public String updateByPrimaryKeySelective(Sys_MenuInfo record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_menuinfo");
        
        if (record.getmName() != null) {
            sql.SET("m_name = #{mName,jdbcType=VARCHAR}");
        }
        
        if (record.getmAkey() != null) {
            sql.SET("m_akey = #{mAkey,jdbcType=VARCHAR}");
        }
        
        if (record.getmCode() != null) {
            sql.SET("m_code = #{mCode,jdbcType=VARCHAR}");
        }
        
        if (record.getmOrdernum() != null) {
            sql.SET("m_ordernum = #{mOrdernum,jdbcType=REAL}");
        }
        
        if (record.getrId() != null) {
            sql.SET("r_id = #{rId,jdbcType=INTEGER}");
        }
        
        if (record.getAppId() != null) {
            sql.SET("app_id = #{appId,jdbcType=VARCHAR}");
        }
        
        if (record.getmIcon() != null) {
            sql.SET("m_icon = #{mIcon,jdbcType=VARCHAR}");
        }
        
        if (record.getmIsenabeld() != null) {
            sql.SET("m_isenabeld = #{mIsenabeld,jdbcType=TINYINT}");
        }
        
        if (record.getmIsshow() != null) {
            sql.SET("m_isshow = #{mIsshow,jdbcType=TINYINT}");
        }
        
        if (record.getmParent() != null) {
            sql.SET("m_parent = #{mParent,jdbcType=INTEGER}");
        }
        
        if (record.getmUrl() != null) {
            sql.SET("m_url = #{mUrl,jdbcType=TIMESTAMP}");
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