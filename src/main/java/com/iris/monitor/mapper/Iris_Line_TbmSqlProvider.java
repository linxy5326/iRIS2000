package com.iris.monitor.mapper;

import com.iris.monitor.entity.Iris_Line_Tbm;
import org.apache.ibatis.jdbc.SQL;

public class Iris_Line_TbmSqlProvider {

    public String insertSelective(Iris_Line_Tbm record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("iris_line_tbm");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getIriId() != null) {
            sql.VALUES("iri_id", "#{iriId,jdbcType=CHAR}");
        }
        
        if (record.getIriId2() != null) {
            sql.VALUES("iri_id2", "#{iriId2,jdbcType=CHAR}");
        }
        
        if (record.getLtCode() != null) {
            sql.VALUES("lt_code", "#{ltCode,jdbcType=CHAR}");
        }
        
        if (record.getLtSfdate() != null) {
            sql.VALUES("lt_sfdate", "#{ltSfdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLtGtdate() != null) {
            sql.VALUES("lt_gtdate", "#{ltGtdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLtSggq() != null) {
            sql.VALUES("lt_sggq", "#{ltSggq,jdbcType=INTEGER}");
        }
        
        if (record.getLtIndate() != null) {
            sql.VALUES("lt_indate", "#{ltIndate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLtOutdate() != null) {
            sql.VALUES("lt_outdate", "#{ltOutdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtCreate() != null) {
            sql.VALUES("gmt_create", "#{gmtCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtModified() != null) {
            sql.VALUES("gmt_modified", "#{gmtModified,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Iris_Line_Tbm record) {
        SQL sql = new SQL();
        sql.UPDATE("iris_line_tbm");
        
        if (record.getIriId() != null) {
            sql.SET("iri_id = #{iriId,jdbcType=CHAR}");
        }
        
        if (record.getIriId2() != null) {
            sql.SET("iri_id2 = #{iriId2,jdbcType=CHAR}");
        }
        
        if (record.getLtCode() != null) {
            sql.SET("lt_code = #{ltCode,jdbcType=CHAR}");
        }
        
        if (record.getLtSfdate() != null) {
            sql.SET("lt_sfdate = #{ltSfdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLtGtdate() != null) {
            sql.SET("lt_gtdate = #{ltGtdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLtSggq() != null) {
            sql.SET("lt_sggq = #{ltSggq,jdbcType=INTEGER}");
        }
        
        if (record.getLtIndate() != null) {
            sql.SET("lt_indate = #{ltIndate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLtOutdate() != null) {
            sql.SET("lt_outdate = #{ltOutdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtCreate() != null) {
            sql.SET("gmt_create = #{gmtCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtModified() != null) {
            sql.SET("gmt_modified = #{gmtModified,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}