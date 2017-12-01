package com.iris.monitor.mapper;

import com.iris.monitor.entity.Iris_Ui_IoMap;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface Iris_Ui_IoMapMapper {
    @Delete({
        "delete from iris_ui_iomap",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into iris_ui_iomap (id, uib_id, ",
        "iri_id, uiop_dv, uiop_name, ",
        "uiop_fe, uiop_tv, ",
        "uiop_num, uiop_isshow, ",
        "uiop_unit, ui_bid)",
        "values (#{id,jdbcType=INTEGER}, #{uibId,jdbcType=INTEGER}, ",
        "#{iriId,jdbcType=INTEGER}, #{uiopDv,jdbcType=VARCHAR}, #{uiopName,jdbcType=VARCHAR}, ",
        "#{uiopFe,jdbcType=VARCHAR}, #{uiopTv,jdbcType=VARCHAR}, ",
        "#{uiopNum,jdbcType=VARCHAR}, #{uiopIsshow,jdbcType=TINYINT}, ",
        "#{uiopUnit,jdbcType=VARCHAR}, #{uiBid,jdbcType=INTEGER})"
    })
    int insert(Iris_Ui_IoMap record);

    @InsertProvider(type=Iris_Ui_IoMapSqlProvider.class, method="insertSelective")
    int insertSelective(Iris_Ui_IoMap record);

    @Select({
        "select",
        "id, uib_id, iri_id, uiop_dv, uiop_name, uiop_fe, uiop_tv, uiop_num, uiop_isshow, ",
        "uiop_unit, ui_bid",
        "from iris_ui_iomap",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="uib_id", property="uibId", jdbcType=JdbcType.INTEGER),
        @Result(column="iri_id", property="iriId", jdbcType=JdbcType.INTEGER),
        @Result(column="uiop_dv", property="uiopDv", jdbcType=JdbcType.VARCHAR),
        @Result(column="uiop_name", property="uiopName", jdbcType=JdbcType.VARCHAR),
        @Result(column="uiop_fe", property="uiopFe", jdbcType=JdbcType.VARCHAR),
        @Result(column="uiop_tv", property="uiopTv", jdbcType=JdbcType.VARCHAR),
        @Result(column="uiop_num", property="uiopNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="uiop_isshow", property="uiopIsshow", jdbcType=JdbcType.TINYINT),
        @Result(column="uiop_unit", property="uiopUnit", jdbcType=JdbcType.VARCHAR),
        @Result(column="ui_bid", property="uiBid", jdbcType=JdbcType.INTEGER)
    })
    Iris_Ui_IoMap selectByPrimaryKey(Integer id);

    @UpdateProvider(type=Iris_Ui_IoMapSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Iris_Ui_IoMap record);

    @Update({
        "update iris_ui_iomap",
        "set uib_id = #{uibId,jdbcType=INTEGER},",
          "iri_id = #{iriId,jdbcType=INTEGER},",
          "uiop_dv = #{uiopDv,jdbcType=VARCHAR},",
          "uiop_name = #{uiopName,jdbcType=VARCHAR},",
          "uiop_fe = #{uiopFe,jdbcType=VARCHAR},",
          "uiop_tv = #{uiopTv,jdbcType=VARCHAR},",
          "uiop_num = #{uiopNum,jdbcType=VARCHAR},",
          "uiop_isshow = #{uiopIsshow,jdbcType=TINYINT},",
          "uiop_unit = #{uiopUnit,jdbcType=VARCHAR},",
          "ui_bid = #{uiBid,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Iris_Ui_IoMap record);
}