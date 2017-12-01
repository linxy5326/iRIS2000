package com.iris.monitor.mapper;

import com.iris.monitor.entity.Iris_Pro_Iop;
import org.apache.ibatis.jdbc.SQL;

public class Iris_Pro_IopSqlProvider {

    public String insertSelective(Iris_Pro_Iop record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("iris_pro_iop");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getIriId() != null) {
            sql.VALUES("iri_id", "#{iriId,jdbcType=CHAR}");
        }
        
        if (record.getIopNum() != null) {
            sql.VALUES("iop_num", "#{iopNum,jdbcType=VARCHAR}");
        }
        
        if (record.getIopBirname() != null) {
            sql.VALUES("iop_birname", "#{iopBirname,jdbcType=VARCHAR}");
        }
        
        if (record.getIopFlagname() != null) {
            sql.VALUES("iop_flagname", "#{iopFlagname,jdbcType=VARCHAR}");
        }
        
        if (record.getIopGroupname() != null) {
            sql.VALUES("iop_groupname", "#{iopGroupname,jdbcType=VARCHAR}");
        }
        
        if (record.getIopPrefix() != null) {
            sql.VALUES("iop_prefix", "#{iopPrefix,jdbcType=VARCHAR}");
        }
        
        if (record.getIopDataaddress() != null) {
            sql.VALUES("iop_dataaddress", "#{iopDataaddress,jdbcType=VARCHAR}");
        }
        
        if (record.getIopElecnum() != null) {
            sql.VALUES("iop_elecnum", "#{iopElecnum,jdbcType=VARCHAR}");
        }
        
        if (record.getIopStaname() != null) {
            sql.VALUES("iop_staname", "#{iopStaname,jdbcType=VARCHAR}");
        }
        
        if (record.getIopDatatype() != null) {
            sql.VALUES("iop_datatype", "#{iopDatatype,jdbcType=VARCHAR}");
        }
        
        if (record.getIopPrecision() != null) {
            sql.VALUES("iop_precision", "#{iopPrecision,jdbcType=VARCHAR}");
        }
        
        if (record.getIopBound() != null) {
            sql.VALUES("iop_bound", "#{iopBound,jdbcType=VARCHAR}");
        }
        
        if (record.getIopTv() != null) {
            sql.VALUES("iop_tv", "#{iopTv,jdbcType=VARCHAR}");
        }
        
        if (record.getIopFe() != null) {
            sql.VALUES("iop_fe", "#{iopFe,jdbcType=VARCHAR}");
        }
        
        if (record.getIopP1() != null) {
            sql.VALUES("iop_p1", "#{iopP1,jdbcType=INTEGER}");
        }
        
        if (record.getIopP2() != null) {
            sql.VALUES("iop_p2", "#{iopP2,jdbcType=VARCHAR}");
        }
        
        if (record.getIopP3() != null) {
            sql.VALUES("iop_p3", "#{iopP3,jdbcType=REAL}");
        }
        
        if (record.getIopEnabeld() != null) {
            sql.VALUES("iop_enabeld", "#{iopEnabeld,jdbcType=TINYINT}");
        }
        
        if (record.getIopRw() != null) {
            sql.VALUES("iop_rw", "#{iopRw,jdbcType=TINYINT}");
        }
        
        if (record.getGmtDatetiem() != null) {
            sql.VALUES("gmt_datetiem", "#{gmtDatetiem,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtDatetime() != null) {
            sql.VALUES("gmt_datetime", "#{gmtDatetime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIsDeleted() != null) {
            sql.VALUES("is_deleted", "#{isDeleted,jdbcType=TINYINT}");
        }
        
        if (record.getIopDesc() != null) {
            sql.VALUES("iop_desc", "#{iopDesc,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Iris_Pro_Iop record) {
        SQL sql = new SQL();
        sql.UPDATE("iris_pro_iop");
        
        if (record.getIriId() != null) {
            sql.SET("iri_id = #{iriId,jdbcType=CHAR}");
        }
        
        if (record.getIopNum() != null) {
            sql.SET("iop_num = #{iopNum,jdbcType=VARCHAR}");
        }
        
        if (record.getIopBirname() != null) {
            sql.SET("iop_birname = #{iopBirname,jdbcType=VARCHAR}");
        }
        
        if (record.getIopFlagname() != null) {
            sql.SET("iop_flagname = #{iopFlagname,jdbcType=VARCHAR}");
        }
        
        if (record.getIopGroupname() != null) {
            sql.SET("iop_groupname = #{iopGroupname,jdbcType=VARCHAR}");
        }
        
        if (record.getIopPrefix() != null) {
            sql.SET("iop_prefix = #{iopPrefix,jdbcType=VARCHAR}");
        }
        
        if (record.getIopDataaddress() != null) {
            sql.SET("iop_dataaddress = #{iopDataaddress,jdbcType=VARCHAR}");
        }
        
        if (record.getIopElecnum() != null) {
            sql.SET("iop_elecnum = #{iopElecnum,jdbcType=VARCHAR}");
        }
        
        if (record.getIopStaname() != null) {
            sql.SET("iop_staname = #{iopStaname,jdbcType=VARCHAR}");
        }
        
        if (record.getIopDatatype() != null) {
            sql.SET("iop_datatype = #{iopDatatype,jdbcType=VARCHAR}");
        }
        
        if (record.getIopPrecision() != null) {
            sql.SET("iop_precision = #{iopPrecision,jdbcType=VARCHAR}");
        }
        
        if (record.getIopBound() != null) {
            sql.SET("iop_bound = #{iopBound,jdbcType=VARCHAR}");
        }
        
        if (record.getIopTv() != null) {
            sql.SET("iop_tv = #{iopTv,jdbcType=VARCHAR}");
        }
        
        if (record.getIopFe() != null) {
            sql.SET("iop_fe = #{iopFe,jdbcType=VARCHAR}");
        }
        
        if (record.getIopP1() != null) {
            sql.SET("iop_p1 = #{iopP1,jdbcType=INTEGER}");
        }
        
        if (record.getIopP2() != null) {
            sql.SET("iop_p2 = #{iopP2,jdbcType=VARCHAR}");
        }
        
        if (record.getIopP3() != null) {
            sql.SET("iop_p3 = #{iopP3,jdbcType=REAL}");
        }
        
        if (record.getIopEnabeld() != null) {
            sql.SET("iop_enabeld = #{iopEnabeld,jdbcType=TINYINT}");
        }
        
        if (record.getIopRw() != null) {
            sql.SET("iop_rw = #{iopRw,jdbcType=TINYINT}");
        }
        
        if (record.getGmtDatetiem() != null) {
            sql.SET("gmt_datetiem = #{gmtDatetiem,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtDatetime() != null) {
            sql.SET("gmt_datetime = #{gmtDatetime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIsDeleted() != null) {
            sql.SET("is_deleted = #{isDeleted,jdbcType=TINYINT}");
        }
        
        if (record.getIopDesc() != null) {
            sql.SET("iop_desc = #{iopDesc,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}