package com.iris.monitor.mapper;

import com.iris.monitor.entity.Sys_AppInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface Sys_AppInfoMapper {
    @Delete({
        "delete from sys_appinfo",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into sys_appinfo (id, app_name, ",
        "app_version, app_providerinfo, ",
        "app_regtime, app_url, ",
        "gmt_modified, gmt_create, ",
        "is_deleted, app_iocn)",
        "values (#{id,jdbcType=VARCHAR}, #{appName,jdbcType=VARCHAR}, ",
        "#{appVersion,jdbcType=VARCHAR}, #{appProviderinfo,jdbcType=VARCHAR}, ",
        "#{appRegtime,jdbcType=TIMESTAMP}, #{appUrl,jdbcType=VARCHAR}, ",
        "#{gmtModified,jdbcType=TIMESTAMP}, #{gmtCreate,jdbcType=TIMESTAMP}, ",
        "#{isDeleted,jdbcType=TINYINT}, #{appIocn,jdbcType=LONGVARCHAR})"
    })
    int insert(Sys_AppInfo record);

    @InsertProvider(type=Sys_AppInfoSqlProvider.class, method="insertSelective")
    int insertSelective(Sys_AppInfo record);

    @Select({
        "select",
        "id, app_name, app_version, app_providerinfo, app_regtime, app_url, gmt_modified, ",
        "gmt_create, is_deleted, app_iocn",
        "from sys_appinfo",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="app_name", property="appName", jdbcType=JdbcType.VARCHAR),
        @Result(column="app_version", property="appVersion", jdbcType=JdbcType.VARCHAR),
        @Result(column="app_providerinfo", property="appProviderinfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="app_regtime", property="appRegtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="app_url", property="appUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_modified", property="gmtModified", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="is_deleted", property="isDeleted", jdbcType=JdbcType.TINYINT),
        @Result(column="app_iocn", property="appIocn", jdbcType=JdbcType.LONGVARCHAR)
    })
    Sys_AppInfo selectByPrimaryKey(String id);

    @UpdateProvider(type=Sys_AppInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Sys_AppInfo record);

    @Update({
        "update sys_appinfo",
        "set app_name = #{appName,jdbcType=VARCHAR},",
          "app_version = #{appVersion,jdbcType=VARCHAR},",
          "app_providerinfo = #{appProviderinfo,jdbcType=VARCHAR},",
          "app_regtime = #{appRegtime,jdbcType=TIMESTAMP},",
          "app_url = #{appUrl,jdbcType=VARCHAR},",
          "gmt_modified = #{gmtModified,jdbcType=TIMESTAMP},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "is_deleted = #{isDeleted,jdbcType=TINYINT},",
          "app_iocn = #{appIocn,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKeyWithBLOBs(Sys_AppInfo record);

    @Update({
        "update sys_appinfo",
        "set app_name = #{appName,jdbcType=VARCHAR},",
          "app_version = #{appVersion,jdbcType=VARCHAR},",
          "app_providerinfo = #{appProviderinfo,jdbcType=VARCHAR},",
          "app_regtime = #{appRegtime,jdbcType=TIMESTAMP},",
          "app_url = #{appUrl,jdbcType=VARCHAR},",
          "gmt_modified = #{gmtModified,jdbcType=TIMESTAMP},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "is_deleted = #{isDeleted,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Sys_AppInfo record);
}