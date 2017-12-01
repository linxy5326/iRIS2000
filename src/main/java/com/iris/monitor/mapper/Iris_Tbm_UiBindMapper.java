package com.iris.monitor.mapper;

import com.iris.monitor.entity.Iris_Tbm_UiBind;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface Iris_Tbm_UiBindMapper {
    @Delete({
        "delete from iris_tbm_uibind",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into iris_tbm_uibind (id, iri_id, ",
        "tub_sort, tub_name, ",
        "ui_id)",
        "values (#{id,jdbcType=INTEGER}, #{iriId,jdbcType=CHAR}, ",
        "#{tubSort,jdbcType=INTEGER}, #{tubName,jdbcType=VARCHAR}, ",
        "#{uiId,jdbcType=INTEGER})"
    })
    int insert(Iris_Tbm_UiBind record);

    @InsertProvider(type=Iris_Tbm_UiBindSqlProvider.class, method="insertSelective")
    int insertSelective(Iris_Tbm_UiBind record);

    @Select({
        "select",
        "id, iri_id, tub_sort, tub_name, ui_id",
        "from iris_tbm_uibind",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="iri_id", property="iriId", jdbcType=JdbcType.CHAR),
        @Result(column="tub_sort", property="tubSort", jdbcType=JdbcType.INTEGER),
        @Result(column="tub_name", property="tubName", jdbcType=JdbcType.VARCHAR),
        @Result(column="ui_id", property="uiId", jdbcType=JdbcType.INTEGER)
    })
    Iris_Tbm_UiBind selectByPrimaryKey(Integer id);

    @UpdateProvider(type=Iris_Tbm_UiBindSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Iris_Tbm_UiBind record);

    @Update({
        "update iris_tbm_uibind",
        "set iri_id = #{iriId,jdbcType=CHAR},",
          "tub_sort = #{tubSort,jdbcType=INTEGER},",
          "tub_name = #{tubName,jdbcType=VARCHAR},",
          "ui_id = #{uiId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Iris_Tbm_UiBind record);
}