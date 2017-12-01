package com.iris.monitor.mapper;

import com.iris.monitor.entity.Sys_ResourceInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface Sys_ResourceInfoMapper {
    @Delete({
        "delete from sys_resourceinfo",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sys_resourceinfo (id, app_id, ",
        "ri_name, ri_path, ",
        "ri_pkgname, ri_type, ",
        "ri_code, ri_desc, ",
        "gmt_create, gmt_modified, ",
        "is_deleted)",
        "values (#{id,jdbcType=INTEGER}, #{appId,jdbcType=VARCHAR}, ",
        "#{riName,jdbcType=VARCHAR}, #{riPath,jdbcType=VARCHAR}, ",
        "#{riPkgname,jdbcType=VARCHAR}, #{riType,jdbcType=TINYINT}, ",
        "#{riCode,jdbcType=VARCHAR}, #{riDesc,jdbcType=VARCHAR}, ",
        "#{gmtCreate,jdbcType=TIMESTAMP}, #{gmtModified,jdbcType=TIMESTAMP}, ",
        "#{isDeleted,jdbcType=TINYINT})"
    })
    int insert(Sys_ResourceInfo record);

    @InsertProvider(type=Sys_ResourceInfoSqlProvider.class, method="insertSelective")
    int insertSelective(Sys_ResourceInfo record);

    @Select({
        "select",
        "id, app_id, ri_name, ri_path, ri_pkgname, ri_type, ri_code, ri_desc, gmt_create, ",
        "gmt_modified, is_deleted",
        "from sys_resourceinfo",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.VARCHAR),
        @Result(column="ri_name", property="riName", jdbcType=JdbcType.VARCHAR),
        @Result(column="ri_path", property="riPath", jdbcType=JdbcType.VARCHAR),
        @Result(column="ri_pkgname", property="riPkgname", jdbcType=JdbcType.VARCHAR),
        @Result(column="ri_type", property="riType", jdbcType=JdbcType.TINYINT),
        @Result(column="ri_code", property="riCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="ri_desc", property="riDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modified", property="gmtModified", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="is_deleted", property="isDeleted", jdbcType=JdbcType.TINYINT)
    })
    Sys_ResourceInfo selectByPrimaryKey(Integer id);

    @UpdateProvider(type=Sys_ResourceInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Sys_ResourceInfo record);

    @Update({
        "update sys_resourceinfo",
        "set app_id = #{appId,jdbcType=VARCHAR},",
          "ri_name = #{riName,jdbcType=VARCHAR},",
          "ri_path = #{riPath,jdbcType=VARCHAR},",
          "ri_pkgname = #{riPkgname,jdbcType=VARCHAR},",
          "ri_type = #{riType,jdbcType=TINYINT},",
          "ri_code = #{riCode,jdbcType=VARCHAR},",
          "ri_desc = #{riDesc,jdbcType=VARCHAR},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modified = #{gmtModified,jdbcType=TIMESTAMP},",
          "is_deleted = #{isDeleted,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Sys_ResourceInfo record);
}