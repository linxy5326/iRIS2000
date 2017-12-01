package com.iris.monitor.mapper;

import com.iris.monitor.entity.Iris_Line_Tbm;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface Iris_Line_TbmMapper {
    @Delete({
        "delete from iris_line_tbm",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into iris_line_tbm (id, iri_id, ",
        "iri_id2, lt_code, lt_sfdate, ",
        "lt_gtdate, lt_sggq, ",
        "lt_indate, lt_outdate, ",
        "gmt_create, gmt_modified)",
        "values (#{id,jdbcType=INTEGER}, #{iriId,jdbcType=CHAR}, ",
        "#{iriId2,jdbcType=CHAR}, #{ltCode,jdbcType=CHAR}, #{ltSfdate,jdbcType=TIMESTAMP}, ",
        "#{ltGtdate,jdbcType=TIMESTAMP}, #{ltSggq,jdbcType=INTEGER}, ",
        "#{ltIndate,jdbcType=TIMESTAMP}, #{ltOutdate,jdbcType=TIMESTAMP}, ",
        "#{gmtCreate,jdbcType=TIMESTAMP}, #{gmtModified,jdbcType=TIMESTAMP})"
    })
    int insert(Iris_Line_Tbm record);

    @InsertProvider(type=Iris_Line_TbmSqlProvider.class, method="insertSelective")
    int insertSelective(Iris_Line_Tbm record);

    @Select({
        "select",
        "id, iri_id, iri_id2, lt_code, lt_sfdate, lt_gtdate, lt_sggq, lt_indate, lt_outdate, ",
        "gmt_create, gmt_modified",
        "from iris_line_tbm",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="iri_id", property="iriId", jdbcType=JdbcType.CHAR),
        @Result(column="iri_id2", property="iriId2", jdbcType=JdbcType.CHAR),
        @Result(column="lt_code", property="ltCode", jdbcType=JdbcType.CHAR),
        @Result(column="lt_sfdate", property="ltSfdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lt_gtdate", property="ltGtdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lt_sggq", property="ltSggq", jdbcType=JdbcType.INTEGER),
        @Result(column="lt_indate", property="ltIndate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lt_outdate", property="ltOutdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modified", property="gmtModified", jdbcType=JdbcType.TIMESTAMP)
    })
    Iris_Line_Tbm selectByPrimaryKey(Integer id);

    @UpdateProvider(type=Iris_Line_TbmSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Iris_Line_Tbm record);

    @Update({
        "update iris_line_tbm",
        "set iri_id = #{iriId,jdbcType=CHAR},",
          "iri_id2 = #{iriId2,jdbcType=CHAR},",
          "lt_code = #{ltCode,jdbcType=CHAR},",
          "lt_sfdate = #{ltSfdate,jdbcType=TIMESTAMP},",
          "lt_gtdate = #{ltGtdate,jdbcType=TIMESTAMP},",
          "lt_sggq = #{ltSggq,jdbcType=INTEGER},",
          "lt_indate = #{ltIndate,jdbcType=TIMESTAMP},",
          "lt_outdate = #{ltOutdate,jdbcType=TIMESTAMP},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modified = #{gmtModified,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Iris_Line_Tbm record);
}