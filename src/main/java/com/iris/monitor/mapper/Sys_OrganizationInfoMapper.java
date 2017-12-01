package com.iris.monitor.mapper;

import com.iris.monitor.entity.Sys_OrganizationInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface Sys_OrganizationInfoMapper {
    @Delete({
        "delete from sys_organizationinfo",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into sys_organizationinfo (id, app_id, ",
        "org_name, org_code, ",
        "org_parent, org_indexcode, ",
        "org_address, org_type, ",
        "org_status, is_deleted, ",
        "gmt_create, gmt_modified, ",
        "org_jianjie)",
        "values (#{id,jdbcType=VARCHAR}, #{appId,jdbcType=VARCHAR}, ",
        "#{orgName,jdbcType=VARCHAR}, #{orgCode,jdbcType=VARCHAR}, ",
        "#{orgParent,jdbcType=VARCHAR}, #{orgIndexcode,jdbcType=VARCHAR}, ",
        "#{orgAddress,jdbcType=VARCHAR}, #{orgType,jdbcType=TINYINT}, ",
        "#{orgStatus,jdbcType=TINYINT}, #{isDeleted,jdbcType=TINYINT}, ",
        "#{gmtCreate,jdbcType=TIMESTAMP}, #{gmtModified,jdbcType=TIMESTAMP}, ",
        "#{orgJianjie,jdbcType=LONGVARCHAR})"
    })
    int insert(Sys_OrganizationInfo record);

    @InsertProvider(type=Sys_OrganizationInfoSqlProvider.class, method="insertSelective")
    int insertSelective(Sys_OrganizationInfo record);

    @Select({
        "select",
        "id, app_id, org_name, org_code, org_parent, org_indexcode, org_address, org_type, ",
        "org_status, is_deleted, gmt_create, gmt_modified, org_jianjie",
        "from sys_organizationinfo",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.VARCHAR),
        @Result(column="org_name", property="orgName", jdbcType=JdbcType.VARCHAR),
        @Result(column="org_code", property="orgCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="org_parent", property="orgParent", jdbcType=JdbcType.VARCHAR),
        @Result(column="org_indexcode", property="orgIndexcode", jdbcType=JdbcType.VARCHAR),
        @Result(column="org_address", property="orgAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="org_type", property="orgType", jdbcType=JdbcType.TINYINT),
        @Result(column="org_status", property="orgStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="is_deleted", property="isDeleted", jdbcType=JdbcType.TINYINT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modified", property="gmtModified", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="org_jianjie", property="orgJianjie", jdbcType=JdbcType.LONGVARCHAR)
    })
    Sys_OrganizationInfo selectByPrimaryKey(String id);

    @UpdateProvider(type=Sys_OrganizationInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Sys_OrganizationInfo record);

    @Update({
        "update sys_organizationinfo",
        "set app_id = #{appId,jdbcType=VARCHAR},",
          "org_name = #{orgName,jdbcType=VARCHAR},",
          "org_code = #{orgCode,jdbcType=VARCHAR},",
          "org_parent = #{orgParent,jdbcType=VARCHAR},",
          "org_indexcode = #{orgIndexcode,jdbcType=VARCHAR},",
          "org_address = #{orgAddress,jdbcType=VARCHAR},",
          "org_type = #{orgType,jdbcType=TINYINT},",
          "org_status = #{orgStatus,jdbcType=TINYINT},",
          "is_deleted = #{isDeleted,jdbcType=TINYINT},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modified = #{gmtModified,jdbcType=TIMESTAMP},",
          "org_jianjie = #{orgJianjie,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKeyWithBLOBs(Sys_OrganizationInfo record);

    @Update({
        "update sys_organizationinfo",
        "set app_id = #{appId,jdbcType=VARCHAR},",
          "org_name = #{orgName,jdbcType=VARCHAR},",
          "org_code = #{orgCode,jdbcType=VARCHAR},",
          "org_parent = #{orgParent,jdbcType=VARCHAR},",
          "org_indexcode = #{orgIndexcode,jdbcType=VARCHAR},",
          "org_address = #{orgAddress,jdbcType=VARCHAR},",
          "org_type = #{orgType,jdbcType=TINYINT},",
          "org_status = #{orgStatus,jdbcType=TINYINT},",
          "is_deleted = #{isDeleted,jdbcType=TINYINT},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modified = #{gmtModified,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Sys_OrganizationInfo record);
}