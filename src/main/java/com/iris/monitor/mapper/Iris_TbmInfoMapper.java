package com.iris.monitor.mapper;

import com.iris.monitor.entity.Iris_TbmInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface Iris_TbmInfoMapper {
    @Delete({
        "delete from iris_tbminfo",
        "where id = #{id,jdbcType=CHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into iris_tbminfo (id, ti_mno, ",
        "ti_fno, ti_name, ti_manufacturer, ",
        "ti_vest, ti_buydate, ",
        "ti_model, ti_length, ",
        "ti_diameter, ti_manfrefixkey, ",
        "ti_type, gmt_create, ",
        "gmt_modified, is_deleted, ",
        "org_id, ti_desc)",
        "values (#{id,jdbcType=CHAR}, #{tiMno,jdbcType=VARCHAR}, ",
        "#{tiFno,jdbcType=VARCHAR}, #{tiName,jdbcType=VARCHAR}, #{tiManufacturer,jdbcType=VARCHAR}, ",
        "#{tiVest,jdbcType=VARCHAR}, #{tiBuydate,jdbcType=TIMESTAMP}, ",
        "#{tiModel,jdbcType=VARCHAR}, #{tiLength,jdbcType=REAL}, ",
        "#{tiDiameter,jdbcType=REAL}, #{tiManfrefixkey,jdbcType=VARCHAR}, ",
        "#{tiType,jdbcType=TINYINT}, #{gmtCreate,jdbcType=TIMESTAMP}, ",
        "#{gmtModified,jdbcType=TIMESTAMP}, #{isDeleted,jdbcType=TINYINT}, ",
        "#{orgId,jdbcType=VARCHAR}, #{tiDesc,jdbcType=LONGVARCHAR})"
    })
    int insert(Iris_TbmInfo record);

    @InsertProvider(type=Iris_TbmInfoSqlProvider.class, method="insertSelective")
    int insertSelective(Iris_TbmInfo record);

    @Select({
        "select",
        "id, ti_mno, ti_fno, ti_name, ti_manufacturer, ti_vest, ti_buydate, ti_model, ",
        "ti_length, ti_diameter, ti_manfrefixkey, ti_type, gmt_create, gmt_modified, ",
        "is_deleted, org_id, ti_desc",
        "from iris_tbminfo",
        "where id = #{id,jdbcType=CHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="ti_mno", property="tiMno", jdbcType=JdbcType.VARCHAR),
        @Result(column="ti_fno", property="tiFno", jdbcType=JdbcType.VARCHAR),
        @Result(column="ti_name", property="tiName", jdbcType=JdbcType.VARCHAR),
        @Result(column="ti_manufacturer", property="tiManufacturer", jdbcType=JdbcType.VARCHAR),
        @Result(column="ti_vest", property="tiVest", jdbcType=JdbcType.VARCHAR),
        @Result(column="ti_buydate", property="tiBuydate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ti_model", property="tiModel", jdbcType=JdbcType.VARCHAR),
        @Result(column="ti_length", property="tiLength", jdbcType=JdbcType.REAL),
        @Result(column="ti_diameter", property="tiDiameter", jdbcType=JdbcType.REAL),
        @Result(column="ti_manfrefixkey", property="tiManfrefixkey", jdbcType=JdbcType.VARCHAR),
        @Result(column="ti_type", property="tiType", jdbcType=JdbcType.TINYINT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modified", property="gmtModified", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="is_deleted", property="isDeleted", jdbcType=JdbcType.TINYINT),
        @Result(column="org_id", property="orgId", jdbcType=JdbcType.VARCHAR),
        @Result(column="ti_desc", property="tiDesc", jdbcType=JdbcType.LONGVARCHAR)
    })
    Iris_TbmInfo selectByPrimaryKey(String id);

    @UpdateProvider(type=Iris_TbmInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Iris_TbmInfo record);

    @Update({
        "update iris_tbminfo",
        "set ti_mno = #{tiMno,jdbcType=VARCHAR},",
          "ti_fno = #{tiFno,jdbcType=VARCHAR},",
          "ti_name = #{tiName,jdbcType=VARCHAR},",
          "ti_manufacturer = #{tiManufacturer,jdbcType=VARCHAR},",
          "ti_vest = #{tiVest,jdbcType=VARCHAR},",
          "ti_buydate = #{tiBuydate,jdbcType=TIMESTAMP},",
          "ti_model = #{tiModel,jdbcType=VARCHAR},",
          "ti_length = #{tiLength,jdbcType=REAL},",
          "ti_diameter = #{tiDiameter,jdbcType=REAL},",
          "ti_manfrefixkey = #{tiManfrefixkey,jdbcType=VARCHAR},",
          "ti_type = #{tiType,jdbcType=TINYINT},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modified = #{gmtModified,jdbcType=TIMESTAMP},",
          "is_deleted = #{isDeleted,jdbcType=TINYINT},",
          "org_id = #{orgId,jdbcType=VARCHAR},",
          "ti_desc = #{tiDesc,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=CHAR}"
    })
    int updateByPrimaryKeyWithBLOBs(Iris_TbmInfo record);

    @Update({
        "update iris_tbminfo",
        "set ti_mno = #{tiMno,jdbcType=VARCHAR},",
          "ti_fno = #{tiFno,jdbcType=VARCHAR},",
          "ti_name = #{tiName,jdbcType=VARCHAR},",
          "ti_manufacturer = #{tiManufacturer,jdbcType=VARCHAR},",
          "ti_vest = #{tiVest,jdbcType=VARCHAR},",
          "ti_buydate = #{tiBuydate,jdbcType=TIMESTAMP},",
          "ti_model = #{tiModel,jdbcType=VARCHAR},",
          "ti_length = #{tiLength,jdbcType=REAL},",
          "ti_diameter = #{tiDiameter,jdbcType=REAL},",
          "ti_manfrefixkey = #{tiManfrefixkey,jdbcType=VARCHAR},",
          "ti_type = #{tiType,jdbcType=TINYINT},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modified = #{gmtModified,jdbcType=TIMESTAMP},",
          "is_deleted = #{isDeleted,jdbcType=TINYINT},",
          "org_id = #{orgId,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=CHAR}"
    })
    int updateByPrimaryKey(Iris_TbmInfo record);
}