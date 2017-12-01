package com.iris.monitor.mapper;

import com.iris.monitor.entity.Iris_Pro_Sec_Line;
import org.apache.ibatis.jdbc.SQL;

public class Iris_Pro_Sec_LineSqlProvider {

    public String insertSelective(Iris_Pro_Sec_Line record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("iris_pro_sec_line");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=CHAR}");
        }
        
        if (record.getsId() != null) {
            sql.VALUES("s_id", "#{sId,jdbcType=CHAR}");
        }
        
        if (record.getSlName() != null) {
            sql.VALUES("sl_name", "#{slName,jdbcType=VARCHAR}");
        }
        
        if (record.getSlSeMileage() != null) {
            sql.VALUES("sl_se_mileage", "#{slSeMileage,jdbcType=VARCHAR}");
        }
        
        if (record.getSlSePosition() != null) {
            sql.VALUES("sl_se_position", "#{slSePosition,jdbcType=VARCHAR}");
        }
        
        if (record.getSlStartringno() != null) {
            sql.VALUES("sl_startringno", "#{slStartringno,jdbcType=INTEGER}");
        }
        
        if (record.getSlRingnum() != null) {
            sql.VALUES("sl_ringnum", "#{slRingnum,jdbcType=INTEGER}");
        }
        
        if (record.getSlLength() != null) {
            sql.VALUES("sl_length", "#{slLength,jdbcType=REAL}");
        }
        
        if (record.getSlJhgq() != null) {
            sql.VALUES("sl_jhgq", "#{slJhgq,jdbcType=INTEGER}");
        }
        
        if (record.getSlPrefix() != null) {
            sql.VALUES("sl_prefix", "#{slPrefix,jdbcType=VARCHAR}");
        }
        
        if (record.getGmtCreate() != null) {
            sql.VALUES("gmt_create", "#{gmtCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtModified() != null) {
            sql.VALUES("gmt_modified", "#{gmtModified,jdbcType=TIMESTAMP}");
        }
        
        if (record.getsInfoid() != null) {
            sql.VALUES("s_infoId", "#{sInfoid,jdbcType=VARCHAR}");
        }
        
        if (record.getSlDesc() != null) {
            sql.VALUES("sl_desc", "#{slDesc,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Iris_Pro_Sec_Line record) {
        SQL sql = new SQL();
        sql.UPDATE("iris_pro_sec_line");
        
        if (record.getsId() != null) {
            sql.SET("s_id = #{sId,jdbcType=CHAR}");
        }
        
        if (record.getSlName() != null) {
            sql.SET("sl_name = #{slName,jdbcType=VARCHAR}");
        }
        
        if (record.getSlSeMileage() != null) {
            sql.SET("sl_se_mileage = #{slSeMileage,jdbcType=VARCHAR}");
        }
        
        if (record.getSlSePosition() != null) {
            sql.SET("sl_se_position = #{slSePosition,jdbcType=VARCHAR}");
        }
        
        if (record.getSlStartringno() != null) {
            sql.SET("sl_startringno = #{slStartringno,jdbcType=INTEGER}");
        }
        
        if (record.getSlRingnum() != null) {
            sql.SET("sl_ringnum = #{slRingnum,jdbcType=INTEGER}");
        }
        
        if (record.getSlLength() != null) {
            sql.SET("sl_length = #{slLength,jdbcType=REAL}");
        }
        
        if (record.getSlJhgq() != null) {
            sql.SET("sl_jhgq = #{slJhgq,jdbcType=INTEGER}");
        }
        
        if (record.getSlPrefix() != null) {
            sql.SET("sl_prefix = #{slPrefix,jdbcType=VARCHAR}");
        }
        
        if (record.getGmtCreate() != null) {
            sql.SET("gmt_create = #{gmtCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtModified() != null) {
            sql.SET("gmt_modified = #{gmtModified,jdbcType=TIMESTAMP}");
        }
        
        if (record.getsInfoid() != null) {
            sql.SET("s_infoId = #{sInfoid,jdbcType=VARCHAR}");
        }
        
        if (record.getSlDesc() != null) {
            sql.SET("sl_desc = #{slDesc,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=CHAR}");
        
        return sql.toString();
    }
}