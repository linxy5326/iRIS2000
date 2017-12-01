package com.iris.monitor.mapper;

import com.iris.monitor.entity.Iris_Ici_Ui;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface Iris_Ici_UiMapper {
    @Delete({
        "delete from iris_ici_ui",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into iris_ici_ui (id, ui_name, ",
        "ui_path, ui_index, ",
        "ui_desc, ui_enabled, ",
        "gmt_cerate, gmt_modified, ",
        "is_deleted, ui_visible)",
        "values (#{id,jdbcType=INTEGER}, #{uiName,jdbcType=VARCHAR}, ",
        "#{uiPath,jdbcType=VARCHAR}, #{uiIndex,jdbcType=INTEGER}, ",
        "#{uiDesc,jdbcType=VARCHAR}, #{uiEnabled,jdbcType=TINYINT}, ",
        "#{gmtCerate,jdbcType=TIMESTAMP}, #{gmtModified,jdbcType=TIMESTAMP}, ",
        "#{isDeleted,jdbcType=TINYINT}, #{uiVisible,jdbcType=TINYINT})"
    })
    int insert(Iris_Ici_Ui record);

    @InsertProvider(type=Iris_Ici_UiSqlProvider.class, method="insertSelective")
    int insertSelective(Iris_Ici_Ui record);

    @Select({
        "select",
        "id, ui_name, ui_path, ui_index, ui_desc, ui_enabled, gmt_cerate, gmt_modified, ",
        "is_deleted, ui_visible",
        "from iris_ici_ui",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="ui_name", property="uiName", jdbcType=JdbcType.VARCHAR),
        @Result(column="ui_path", property="uiPath", jdbcType=JdbcType.VARCHAR),
        @Result(column="ui_index", property="uiIndex", jdbcType=JdbcType.INTEGER),
        @Result(column="ui_desc", property="uiDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="ui_enabled", property="uiEnabled", jdbcType=JdbcType.TINYINT),
        @Result(column="gmt_cerate", property="gmtCerate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modified", property="gmtModified", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="is_deleted", property="isDeleted", jdbcType=JdbcType.TINYINT),
        @Result(column="ui_visible", property="uiVisible", jdbcType=JdbcType.TINYINT)
    })
    Iris_Ici_Ui selectByPrimaryKey(Integer id);

    @UpdateProvider(type=Iris_Ici_UiSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Iris_Ici_Ui record);

    @Update({
        "update iris_ici_ui",
        "set ui_name = #{uiName,jdbcType=VARCHAR},",
          "ui_path = #{uiPath,jdbcType=VARCHAR},",
          "ui_index = #{uiIndex,jdbcType=INTEGER},",
          "ui_desc = #{uiDesc,jdbcType=VARCHAR},",
          "ui_enabled = #{uiEnabled,jdbcType=TINYINT},",
          "gmt_cerate = #{gmtCerate,jdbcType=TIMESTAMP},",
          "gmt_modified = #{gmtModified,jdbcType=TIMESTAMP},",
          "is_deleted = #{isDeleted,jdbcType=TINYINT},",
          "ui_visible = #{uiVisible,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Iris_Ici_Ui record);
}