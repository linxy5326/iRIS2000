package com.iris.monitor.mapper;

import com.iris.monitor.entity.Iris_Pro_Iop;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface Iris_Pro_IopMapper {
    @Delete({
        "delete from iris_pro_iop",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into iris_pro_iop (id, iri_id, ",
        "iop_num, iop_birname, ",
        "iop_flagname, iop_groupname, ",
        "iop_prefix, iop_dataaddress, ",
        "iop_elecnum, iop_staname, ",
        "iop_datatype, iop_precision, ",
        "iop_bound, iop_tv, ",
        "iop_fe, iop_p1, iop_p2, ",
        "iop_p3, iop_enabeld, ",
        "iop_rw, gmt_datetiem, ",
        "gmt_datetime, is_deleted, ",
        "iop_desc)",
        "values (#{id,jdbcType=INTEGER}, #{iriId,jdbcType=CHAR}, ",
        "#{iopNum,jdbcType=VARCHAR}, #{iopBirname,jdbcType=VARCHAR}, ",
        "#{iopFlagname,jdbcType=VARCHAR}, #{iopGroupname,jdbcType=VARCHAR}, ",
        "#{iopPrefix,jdbcType=VARCHAR}, #{iopDataaddress,jdbcType=VARCHAR}, ",
        "#{iopElecnum,jdbcType=VARCHAR}, #{iopStaname,jdbcType=VARCHAR}, ",
        "#{iopDatatype,jdbcType=VARCHAR}, #{iopPrecision,jdbcType=VARCHAR}, ",
        "#{iopBound,jdbcType=VARCHAR}, #{iopTv,jdbcType=VARCHAR}, ",
        "#{iopFe,jdbcType=VARCHAR}, #{iopP1,jdbcType=INTEGER}, #{iopP2,jdbcType=VARCHAR}, ",
        "#{iopP3,jdbcType=REAL}, #{iopEnabeld,jdbcType=TINYINT}, ",
        "#{iopRw,jdbcType=TINYINT}, #{gmtDatetiem,jdbcType=TIMESTAMP}, ",
        "#{gmtDatetime,jdbcType=TIMESTAMP}, #{isDeleted,jdbcType=TINYINT}, ",
        "#{iopDesc,jdbcType=LONGVARCHAR})"
    })
    int insert(Iris_Pro_Iop record);

    @InsertProvider(type=Iris_Pro_IopSqlProvider.class, method="insertSelective")
    int insertSelective(Iris_Pro_Iop record);

    @Select({
        "select",
        "id, iri_id, iop_num, iop_birname, iop_flagname, iop_groupname, iop_prefix, iop_dataaddress, ",
        "iop_elecnum, iop_staname, iop_datatype, iop_precision, iop_bound, iop_tv, iop_fe, ",
        "iop_p1, iop_p2, iop_p3, iop_enabeld, iop_rw, gmt_datetiem, gmt_datetime, is_deleted, ",
        "iop_desc",
        "from iris_pro_iop",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="iri_id", property="iriId", jdbcType=JdbcType.CHAR),
        @Result(column="iop_num", property="iopNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="iop_birname", property="iopBirname", jdbcType=JdbcType.VARCHAR),
        @Result(column="iop_flagname", property="iopFlagname", jdbcType=JdbcType.VARCHAR),
        @Result(column="iop_groupname", property="iopGroupname", jdbcType=JdbcType.VARCHAR),
        @Result(column="iop_prefix", property="iopPrefix", jdbcType=JdbcType.VARCHAR),
        @Result(column="iop_dataaddress", property="iopDataaddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="iop_elecnum", property="iopElecnum", jdbcType=JdbcType.VARCHAR),
        @Result(column="iop_staname", property="iopStaname", jdbcType=JdbcType.VARCHAR),
        @Result(column="iop_datatype", property="iopDatatype", jdbcType=JdbcType.VARCHAR),
        @Result(column="iop_precision", property="iopPrecision", jdbcType=JdbcType.VARCHAR),
        @Result(column="iop_bound", property="iopBound", jdbcType=JdbcType.VARCHAR),
        @Result(column="iop_tv", property="iopTv", jdbcType=JdbcType.VARCHAR),
        @Result(column="iop_fe", property="iopFe", jdbcType=JdbcType.VARCHAR),
        @Result(column="iop_p1", property="iopP1", jdbcType=JdbcType.INTEGER),
        @Result(column="iop_p2", property="iopP2", jdbcType=JdbcType.VARCHAR),
        @Result(column="iop_p3", property="iopP3", jdbcType=JdbcType.REAL),
        @Result(column="iop_enabeld", property="iopEnabeld", jdbcType=JdbcType.TINYINT),
        @Result(column="iop_rw", property="iopRw", jdbcType=JdbcType.TINYINT),
        @Result(column="gmt_datetiem", property="gmtDatetiem", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_datetime", property="gmtDatetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="is_deleted", property="isDeleted", jdbcType=JdbcType.TINYINT),
        @Result(column="iop_desc", property="iopDesc", jdbcType=JdbcType.LONGVARCHAR)
    })
    Iris_Pro_Iop selectByPrimaryKey(Integer id);

    @UpdateProvider(type=Iris_Pro_IopSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Iris_Pro_Iop record);

    @Update({
        "update iris_pro_iop",
        "set iri_id = #{iriId,jdbcType=CHAR},",
          "iop_num = #{iopNum,jdbcType=VARCHAR},",
          "iop_birname = #{iopBirname,jdbcType=VARCHAR},",
          "iop_flagname = #{iopFlagname,jdbcType=VARCHAR},",
          "iop_groupname = #{iopGroupname,jdbcType=VARCHAR},",
          "iop_prefix = #{iopPrefix,jdbcType=VARCHAR},",
          "iop_dataaddress = #{iopDataaddress,jdbcType=VARCHAR},",
          "iop_elecnum = #{iopElecnum,jdbcType=VARCHAR},",
          "iop_staname = #{iopStaname,jdbcType=VARCHAR},",
          "iop_datatype = #{iopDatatype,jdbcType=VARCHAR},",
          "iop_precision = #{iopPrecision,jdbcType=VARCHAR},",
          "iop_bound = #{iopBound,jdbcType=VARCHAR},",
          "iop_tv = #{iopTv,jdbcType=VARCHAR},",
          "iop_fe = #{iopFe,jdbcType=VARCHAR},",
          "iop_p1 = #{iopP1,jdbcType=INTEGER},",
          "iop_p2 = #{iopP2,jdbcType=VARCHAR},",
          "iop_p3 = #{iopP3,jdbcType=REAL},",
          "iop_enabeld = #{iopEnabeld,jdbcType=TINYINT},",
          "iop_rw = #{iopRw,jdbcType=TINYINT},",
          "gmt_datetiem = #{gmtDatetiem,jdbcType=TIMESTAMP},",
          "gmt_datetime = #{gmtDatetime,jdbcType=TIMESTAMP},",
          "is_deleted = #{isDeleted,jdbcType=TINYINT},",
          "iop_desc = #{iopDesc,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(Iris_Pro_Iop record);

    @Update({
        "update iris_pro_iop",
        "set iri_id = #{iriId,jdbcType=CHAR},",
          "iop_num = #{iopNum,jdbcType=VARCHAR},",
          "iop_birname = #{iopBirname,jdbcType=VARCHAR},",
          "iop_flagname = #{iopFlagname,jdbcType=VARCHAR},",
          "iop_groupname = #{iopGroupname,jdbcType=VARCHAR},",
          "iop_prefix = #{iopPrefix,jdbcType=VARCHAR},",
          "iop_dataaddress = #{iopDataaddress,jdbcType=VARCHAR},",
          "iop_elecnum = #{iopElecnum,jdbcType=VARCHAR},",
          "iop_staname = #{iopStaname,jdbcType=VARCHAR},",
          "iop_datatype = #{iopDatatype,jdbcType=VARCHAR},",
          "iop_precision = #{iopPrecision,jdbcType=VARCHAR},",
          "iop_bound = #{iopBound,jdbcType=VARCHAR},",
          "iop_tv = #{iopTv,jdbcType=VARCHAR},",
          "iop_fe = #{iopFe,jdbcType=VARCHAR},",
          "iop_p1 = #{iopP1,jdbcType=INTEGER},",
          "iop_p2 = #{iopP2,jdbcType=VARCHAR},",
          "iop_p3 = #{iopP3,jdbcType=REAL},",
          "iop_enabeld = #{iopEnabeld,jdbcType=TINYINT},",
          "iop_rw = #{iopRw,jdbcType=TINYINT},",
          "gmt_datetiem = #{gmtDatetiem,jdbcType=TIMESTAMP},",
          "gmt_datetime = #{gmtDatetime,jdbcType=TIMESTAMP},",
          "is_deleted = #{isDeleted,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Iris_Pro_Iop record);
}