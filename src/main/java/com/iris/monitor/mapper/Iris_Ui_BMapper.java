package com.iris.monitor.mapper;

import com.iris.monitor.entity.Iris_Ui_B;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface Iris_Ui_BMapper {
    @Delete({
        "delete from iris_ui_b",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into iris_ui_b (id, uib_name, ",
        "uib_uint, uib_de, ",
        "ui_id, iop_tv, iop_fe)",
        "values (#{id,jdbcType=INTEGER}, #{uibName,jdbcType=VARCHAR}, ",
        "#{uibUint,jdbcType=VARCHAR}, #{uibDe,jdbcType=VARCHAR}, ",
        "#{uiId,jdbcType=INTEGER}, #{iopTv,jdbcType=VARCHAR}, #{iopFe,jdbcType=VARCHAR})"
    })
    int insert(Iris_Ui_B record);

    @InsertProvider(type=Iris_Ui_BSqlProvider.class, method="insertSelective")
    int insertSelective(Iris_Ui_B record);

    @Select({
        "select",
        "id, uib_name, uib_uint, uib_de, ui_id, iop_tv, iop_fe",
        "from iris_ui_b",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="uib_name", property="uibName", jdbcType=JdbcType.VARCHAR),
        @Result(column="uib_uint", property="uibUint", jdbcType=JdbcType.VARCHAR),
        @Result(column="uib_de", property="uibDe", jdbcType=JdbcType.VARCHAR),
        @Result(column="ui_id", property="uiId", jdbcType=JdbcType.INTEGER),
        @Result(column="iop_tv", property="iopTv", jdbcType=JdbcType.VARCHAR),
        @Result(column="iop_fe", property="iopFe", jdbcType=JdbcType.VARCHAR)
    })
    Iris_Ui_B selectByPrimaryKey(Integer id);

    @UpdateProvider(type=Iris_Ui_BSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Iris_Ui_B record);

    @Update({
        "update iris_ui_b",
        "set uib_name = #{uibName,jdbcType=VARCHAR},",
          "uib_uint = #{uibUint,jdbcType=VARCHAR},",
          "uib_de = #{uibDe,jdbcType=VARCHAR},",
          "ui_id = #{uiId,jdbcType=INTEGER},",
          "iop_tv = #{iopTv,jdbcType=VARCHAR},",
          "iop_fe = #{iopFe,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Iris_Ui_B record);
}