package com.iris.monitor.mapper;

import com.iris.monitor.entity.Iris_Project;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface Iris_ProjectMapper {
    @Delete({
        "delete from iris_project",
        "where id = #{id,jdbcType=CHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into iris_project (id, org_id, ",
        "pi_pmcode, pi_name, ",
        "pi_province, pi_position, ",
        "pi_yzdw, pi_cbdw, ",
        "pi_sgdw, pi_address, ",
        "pi_opendate, pi_colsedate, ",
        "pi_status, pi_flag, ",
        "gmt_create, gmt_modified, ",
        "is_deleted, pi_desc)",
        "values (#{id,jdbcType=CHAR}, #{orgId,jdbcType=VARCHAR}, ",
        "#{piPmcode,jdbcType=VARCHAR}, #{piName,jdbcType=VARCHAR}, ",
        "#{piProvince,jdbcType=VARCHAR}, #{piPosition,jdbcType=VARCHAR}, ",
        "#{piYzdw,jdbcType=VARCHAR}, #{piCbdw,jdbcType=VARCHAR}, ",
        "#{piSgdw,jdbcType=VARCHAR}, #{piAddress,jdbcType=VARCHAR}, ",
        "#{piOpendate,jdbcType=TIMESTAMP}, #{piColsedate,jdbcType=TIMESTAMP}, ",
        "#{piStatus,jdbcType=TINYINT}, #{piFlag,jdbcType=TINYINT}, ",
        "#{gmtCreate,jdbcType=TIMESTAMP}, #{gmtModified,jdbcType=TIMESTAMP}, ",
        "#{isDeleted,jdbcType=TINYINT}, #{piDesc,jdbcType=LONGVARCHAR})"
    })
    int insert(Iris_Project record);

    @InsertProvider(type=Iris_ProjectSqlProvider.class, method="insertSelective")
    int insertSelective(Iris_Project record);

    @Select({
        "select",
        "id, org_id, pi_pmcode, pi_name, pi_province, pi_position, pi_yzdw, pi_cbdw, ",
        "pi_sgdw, pi_address, pi_opendate, pi_colsedate, pi_status, pi_flag, gmt_create, ",
        "gmt_modified, is_deleted, pi_desc",
        "from iris_project",
        "where id = #{id,jdbcType=CHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="org_id", property="orgId", jdbcType=JdbcType.VARCHAR),
        @Result(column="pi_pmcode", property="piPmcode", jdbcType=JdbcType.VARCHAR),
        @Result(column="pi_name", property="piName", jdbcType=JdbcType.VARCHAR),
        @Result(column="pi_province", property="piProvince", jdbcType=JdbcType.VARCHAR),
        @Result(column="pi_position", property="piPosition", jdbcType=JdbcType.VARCHAR),
        @Result(column="pi_yzdw", property="piYzdw", jdbcType=JdbcType.VARCHAR),
        @Result(column="pi_cbdw", property="piCbdw", jdbcType=JdbcType.VARCHAR),
        @Result(column="pi_sgdw", property="piSgdw", jdbcType=JdbcType.VARCHAR),
        @Result(column="pi_address", property="piAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="pi_opendate", property="piOpendate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="pi_colsedate", property="piColsedate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="pi_status", property="piStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="pi_flag", property="piFlag", jdbcType=JdbcType.TINYINT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modified", property="gmtModified", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="is_deleted", property="isDeleted", jdbcType=JdbcType.TINYINT),
        @Result(column="pi_desc", property="piDesc", jdbcType=JdbcType.LONGVARCHAR)
    })
    Iris_Project selectByPrimaryKey(String id);

    @UpdateProvider(type=Iris_ProjectSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Iris_Project record);

    @Update({
        "update iris_project",
        "set org_id = #{orgId,jdbcType=VARCHAR},",
          "pi_pmcode = #{piPmcode,jdbcType=VARCHAR},",
          "pi_name = #{piName,jdbcType=VARCHAR},",
          "pi_province = #{piProvince,jdbcType=VARCHAR},",
          "pi_position = #{piPosition,jdbcType=VARCHAR},",
          "pi_yzdw = #{piYzdw,jdbcType=VARCHAR},",
          "pi_cbdw = #{piCbdw,jdbcType=VARCHAR},",
          "pi_sgdw = #{piSgdw,jdbcType=VARCHAR},",
          "pi_address = #{piAddress,jdbcType=VARCHAR},",
          "pi_opendate = #{piOpendate,jdbcType=TIMESTAMP},",
          "pi_colsedate = #{piColsedate,jdbcType=TIMESTAMP},",
          "pi_status = #{piStatus,jdbcType=TINYINT},",
          "pi_flag = #{piFlag,jdbcType=TINYINT},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modified = #{gmtModified,jdbcType=TIMESTAMP},",
          "is_deleted = #{isDeleted,jdbcType=TINYINT},",
          "pi_desc = #{piDesc,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=CHAR}"
    })
    int updateByPrimaryKeyWithBLOBs(Iris_Project record);

    @Update({
        "update iris_project",
        "set org_id = #{orgId,jdbcType=VARCHAR},",
          "pi_pmcode = #{piPmcode,jdbcType=VARCHAR},",
          "pi_name = #{piName,jdbcType=VARCHAR},",
          "pi_province = #{piProvince,jdbcType=VARCHAR},",
          "pi_position = #{piPosition,jdbcType=VARCHAR},",
          "pi_yzdw = #{piYzdw,jdbcType=VARCHAR},",
          "pi_cbdw = #{piCbdw,jdbcType=VARCHAR},",
          "pi_sgdw = #{piSgdw,jdbcType=VARCHAR},",
          "pi_address = #{piAddress,jdbcType=VARCHAR},",
          "pi_opendate = #{piOpendate,jdbcType=TIMESTAMP},",
          "pi_colsedate = #{piColsedate,jdbcType=TIMESTAMP},",
          "pi_status = #{piStatus,jdbcType=TINYINT},",
          "pi_flag = #{piFlag,jdbcType=TINYINT},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modified = #{gmtModified,jdbcType=TIMESTAMP},",
          "is_deleted = #{isDeleted,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=CHAR}"
    })
    int updateByPrimaryKey(Iris_Project record);
}