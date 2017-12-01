package com.iris.monitor.mapper;

import com.iris.monitor.entity.Iris_Pro_Section;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface Iris_Pro_SectionMapper {
    @Delete({
        "delete from iris_pro_section",
        "where id = #{id,jdbcType=CHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into iris_pro_section (id, ps_name, ",
        "ps_sectionlen, ps_se_loc, ",
        "ps_se_mileage, ps_linecount, ",
        "gmt_create, gmt_modified, ",
        "pro_id, ps_desc)",
        "values (#{id,jdbcType=CHAR}, #{psName,jdbcType=VARCHAR}, ",
        "#{psSectionlen,jdbcType=REAL}, #{psSeLoc,jdbcType=VARCHAR}, ",
        "#{psSeMileage,jdbcType=VARCHAR}, #{psLinecount,jdbcType=INTEGER}, ",
        "#{gmtCreate,jdbcType=TIMESTAMP}, #{gmtModified,jdbcType=TIMESTAMP}, ",
        "#{proId,jdbcType=CHAR}, #{psDesc,jdbcType=LONGVARCHAR})"
    })
    int insert(Iris_Pro_Section record);

    @InsertProvider(type=Iris_Pro_SectionSqlProvider.class, method="insertSelective")
    int insertSelective(Iris_Pro_Section record);

    @Select({
        "select",
        "id, ps_name, ps_sectionlen, ps_se_loc, ps_se_mileage, ps_linecount, gmt_create, ",
        "gmt_modified, pro_id, ps_desc",
        "from iris_pro_section",
        "where id = #{id,jdbcType=CHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="ps_name", property="psName", jdbcType=JdbcType.VARCHAR),
        @Result(column="ps_sectionlen", property="psSectionlen", jdbcType=JdbcType.REAL),
        @Result(column="ps_se_loc", property="psSeLoc", jdbcType=JdbcType.VARCHAR),
        @Result(column="ps_se_mileage", property="psSeMileage", jdbcType=JdbcType.VARCHAR),
        @Result(column="ps_linecount", property="psLinecount", jdbcType=JdbcType.INTEGER),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modified", property="gmtModified", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="pro_id", property="proId", jdbcType=JdbcType.CHAR),
        @Result(column="ps_desc", property="psDesc", jdbcType=JdbcType.LONGVARCHAR)
    })
    Iris_Pro_Section selectByPrimaryKey(String id);

    @UpdateProvider(type=Iris_Pro_SectionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Iris_Pro_Section record);

    @Update({
        "update iris_pro_section",
        "set ps_name = #{psName,jdbcType=VARCHAR},",
          "ps_sectionlen = #{psSectionlen,jdbcType=REAL},",
          "ps_se_loc = #{psSeLoc,jdbcType=VARCHAR},",
          "ps_se_mileage = #{psSeMileage,jdbcType=VARCHAR},",
          "ps_linecount = #{psLinecount,jdbcType=INTEGER},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modified = #{gmtModified,jdbcType=TIMESTAMP},",
          "pro_id = #{proId,jdbcType=CHAR},",
          "ps_desc = #{psDesc,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=CHAR}"
    })
    int updateByPrimaryKeyWithBLOBs(Iris_Pro_Section record);

    @Update({
        "update iris_pro_section",
        "set ps_name = #{psName,jdbcType=VARCHAR},",
          "ps_sectionlen = #{psSectionlen,jdbcType=REAL},",
          "ps_se_loc = #{psSeLoc,jdbcType=VARCHAR},",
          "ps_se_mileage = #{psSeMileage,jdbcType=VARCHAR},",
          "ps_linecount = #{psLinecount,jdbcType=INTEGER},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modified = #{gmtModified,jdbcType=TIMESTAMP},",
          "pro_id = #{proId,jdbcType=CHAR}",
        "where id = #{id,jdbcType=CHAR}"
    })
    int updateByPrimaryKey(Iris_Pro_Section record);
}