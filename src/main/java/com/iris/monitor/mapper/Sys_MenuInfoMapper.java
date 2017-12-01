package com.iris.monitor.mapper;

import com.iris.monitor.entity.Sys_MenuInfo;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface Sys_MenuInfoMapper {
    @Delete({
        "delete from sys_menuinfo",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sys_menuinfo (id, m_name, ",
        "m_akey, m_code, m_ordernum, ",
        "r_id, app_id, m_icon, ",
        "m_isenabeld, m_isshow, ",
        "m_parent, m_url, ",
        "gmt_create, gmt_modified, ",
        "is_deleted)",
        "values (#{id,jdbcType=INTEGER}, #{mName,jdbcType=VARCHAR}, ",
        "#{mAkey,jdbcType=VARCHAR}, #{mCode,jdbcType=VARCHAR}, #{mOrdernum,jdbcType=REAL}, ",
        "#{rId,jdbcType=INTEGER}, #{appId,jdbcType=VARCHAR}, #{mIcon,jdbcType=VARCHAR}, ",
        "#{mIsenabeld,jdbcType=TINYINT}, #{mIsshow,jdbcType=TINYINT}, ",
        "#{mParent,jdbcType=INTEGER}, #{mUrl,jdbcType=TIMESTAMP}, ",
        "#{gmtCreate,jdbcType=TIMESTAMP}, #{gmtModified,jdbcType=TIMESTAMP}, ",
        "#{isDeleted,jdbcType=TINYINT})"
    })
    int insert(Sys_MenuInfo record);

    @InsertProvider(type=Sys_MenuInfoSqlProvider.class, method="insertSelective")
    int insertSelective(Sys_MenuInfo record);

    @Select({
        "select",
        "id, m_name, m_akey, m_code, m_ordernum, r_id, app_id, m_icon, m_isenabeld, m_isshow, ",
        "m_parent, m_url, gmt_create, gmt_modified, is_deleted",
        "from sys_menuinfo",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="m_name", property="mName", jdbcType=JdbcType.VARCHAR),
        @Result(column="m_akey", property="mAkey", jdbcType=JdbcType.VARCHAR),
        @Result(column="m_code", property="mCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="m_ordernum", property="mOrdernum", jdbcType=JdbcType.REAL),
        @Result(column="r_id", property="rId", jdbcType=JdbcType.INTEGER),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.VARCHAR),
        @Result(column="m_icon", property="mIcon", jdbcType=JdbcType.VARCHAR),
        @Result(column="m_isenabeld", property="mIsenabeld", jdbcType=JdbcType.TINYINT),
        @Result(column="m_isshow", property="mIsshow", jdbcType=JdbcType.TINYINT),
        @Result(column="m_parent", property="mParent", jdbcType=JdbcType.INTEGER),
        @Result(column="m_url", property="mUrl", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modified", property="gmtModified", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="is_deleted", property="isDeleted", jdbcType=JdbcType.TINYINT)
    })
    Sys_MenuInfo selectByPrimaryKey(Integer id);
    
    @Select({
        "select",
        "id, m_name, m_akey, m_code, m_ordernum, r_id, app_id, m_icon, m_isenabeld, m_isshow, ",
        "m_parent, m_url, gmt_create, gmt_modified, is_deleted",
        "from sys_menuinfo "
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="m_name", property="mName", jdbcType=JdbcType.VARCHAR),
        @Result(column="m_akey", property="mAkey", jdbcType=JdbcType.VARCHAR),
        @Result(column="m_code", property="mCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="m_ordernum", property="mOrdernum", jdbcType=JdbcType.REAL),
        @Result(column="r_id", property="rId", jdbcType=JdbcType.INTEGER),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.VARCHAR),
        @Result(column="m_icon", property="mIcon", jdbcType=JdbcType.VARCHAR),
        @Result(column="m_isenabeld", property="mIsenabeld", jdbcType=JdbcType.TINYINT),
        @Result(column="m_isshow", property="mIsshow", jdbcType=JdbcType.TINYINT),
        @Result(column="m_parent", property="mParent", jdbcType=JdbcType.INTEGER),
        @Result(column="m_url", property="mUrl", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modified", property="gmtModified", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="is_deleted", property="isDeleted", jdbcType=JdbcType.TINYINT)
    })
    
    List<Sys_MenuInfo> selectAllMenuInfo();

    @UpdateProvider(type=Sys_MenuInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Sys_MenuInfo record);

    @Update({
        "update sys_menuinfo",
        "set m_name = #{mName,jdbcType=VARCHAR},",
          "m_akey = #{mAkey,jdbcType=VARCHAR},",
          "m_code = #{mCode,jdbcType=VARCHAR},",
          "m_ordernum = #{mOrdernum,jdbcType=REAL},",
          "r_id = #{rId,jdbcType=INTEGER},",
          "app_id = #{appId,jdbcType=VARCHAR},",
          "m_icon = #{mIcon,jdbcType=VARCHAR},",
          "m_isenabeld = #{mIsenabeld,jdbcType=TINYINT},",
          "m_isshow = #{mIsshow,jdbcType=TINYINT},",
          "m_parent = #{mParent,jdbcType=INTEGER},",
          "m_url = #{mUrl,jdbcType=TIMESTAMP},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modified = #{gmtModified,jdbcType=TIMESTAMP},",
          "is_deleted = #{isDeleted,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Sys_MenuInfo record);
}