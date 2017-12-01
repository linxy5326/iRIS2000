package com.iris.monitor.mapper;

import com.iris.monitor.entity.Sys_UserProfile;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface Sys_UserProfileMapper {
    @Delete({
        "delete from sys_userprofile",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sys_userprofile (id, gmt_create, ",
        "gmt_modified, ua_id, ",
        "pf_data)",
        "values (#{id,jdbcType=INTEGER}, #{gmtCreate,jdbcType=TIMESTAMP}, ",
        "#{gmtModified,jdbcType=TIMESTAMP}, #{uaId,jdbcType=INTEGER}, ",
        "#{pfData,jdbcType=LONGVARCHAR})"
    })
    int insert(Sys_UserProfile record);

    @InsertProvider(type=Sys_UserProfileSqlProvider.class, method="insertSelective")
    int insertSelective(Sys_UserProfile record);

    @Select({
        "select",
        "id, gmt_create, gmt_modified, ua_id, pf_data",
        "from sys_userprofile",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modified", property="gmtModified", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ua_id", property="uaId", jdbcType=JdbcType.INTEGER),
        @Result(column="pf_data", property="pfData", jdbcType=JdbcType.LONGVARCHAR)
    })
    Sys_UserProfile selectByPrimaryKey(Integer id);

    @UpdateProvider(type=Sys_UserProfileSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Sys_UserProfile record);

    @Update({
        "update sys_userprofile",
        "set gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modified = #{gmtModified,jdbcType=TIMESTAMP},",
          "ua_id = #{uaId,jdbcType=INTEGER},",
          "pf_data = #{pfData,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(Sys_UserProfile record);

    @Update({
        "update sys_userprofile",
        "set gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modified = #{gmtModified,jdbcType=TIMESTAMP},",
          "ua_id = #{uaId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Sys_UserProfile record);
}