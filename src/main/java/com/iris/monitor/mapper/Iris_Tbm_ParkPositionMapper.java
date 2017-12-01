package com.iris.monitor.mapper;

import com.iris.monitor.entity.Iris_Tbm_ParkPosition;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface Iris_Tbm_ParkPositionMapper {
    @Delete({
        "delete from iris_tbm_parkposition",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into iris_tbm_parkposition (id, tpk_address, ",
        "tpk_name, tpk_position, ",
        "gmt_create, gmt_modified, ",
        "tpk_desc)",
        "values (#{id,jdbcType=INTEGER}, #{tpkAddress,jdbcType=VARCHAR}, ",
        "#{tpkName,jdbcType=VARCHAR}, #{tpkPosition,jdbcType=VARCHAR}, ",
        "#{gmtCreate,jdbcType=TIMESTAMP}, #{gmtModified,jdbcType=TIMESTAMP}, ",
        "#{tpkDesc,jdbcType=LONGVARCHAR})"
    })
    int insert(Iris_Tbm_ParkPosition record);

    @InsertProvider(type=Iris_Tbm_ParkPositionSqlProvider.class, method="insertSelective")
    int insertSelective(Iris_Tbm_ParkPosition record);

    @Select({
        "select",
        "id, tpk_address, tpk_name, tpk_position, gmt_create, gmt_modified, tpk_desc",
        "from iris_tbm_parkposition",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="tpk_address", property="tpkAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="tpk_name", property="tpkName", jdbcType=JdbcType.VARCHAR),
        @Result(column="tpk_position", property="tpkPosition", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modified", property="gmtModified", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="tpk_desc", property="tpkDesc", jdbcType=JdbcType.LONGVARCHAR)
    })
    Iris_Tbm_ParkPosition selectByPrimaryKey(Integer id);

    @UpdateProvider(type=Iris_Tbm_ParkPositionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Iris_Tbm_ParkPosition record);

    @Update({
        "update iris_tbm_parkposition",
        "set tpk_address = #{tpkAddress,jdbcType=VARCHAR},",
          "tpk_name = #{tpkName,jdbcType=VARCHAR},",
          "tpk_position = #{tpkPosition,jdbcType=VARCHAR},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modified = #{gmtModified,jdbcType=TIMESTAMP},",
          "tpk_desc = #{tpkDesc,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(Iris_Tbm_ParkPosition record);

    @Update({
        "update iris_tbm_parkposition",
        "set tpk_address = #{tpkAddress,jdbcType=VARCHAR},",
          "tpk_name = #{tpkName,jdbcType=VARCHAR},",
          "tpk_position = #{tpkPosition,jdbcType=VARCHAR},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modified = #{gmtModified,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Iris_Tbm_ParkPosition record);
}