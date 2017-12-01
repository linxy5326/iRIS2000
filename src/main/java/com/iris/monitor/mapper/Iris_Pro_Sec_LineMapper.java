package com.iris.monitor.mapper;

import com.iris.monitor.entity.Iris_Pro_Sec_Line;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface Iris_Pro_Sec_LineMapper {
    @Delete({
        "delete from iris_pro_sec_line",
        "where id = #{id,jdbcType=CHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into iris_pro_sec_line (id, s_id, sl_name, ",
        "sl_se_mileage, sl_se_position, ",
        "sl_startringno, sl_ringnum, ",
        "sl_length, sl_jhgq, sl_prefix, ",
        "gmt_create, gmt_modified, ",
        "s_infoId, sl_desc)",
        "values (#{id,jdbcType=CHAR}, #{sId,jdbcType=CHAR}, #{slName,jdbcType=VARCHAR}, ",
        "#{slSeMileage,jdbcType=VARCHAR}, #{slSePosition,jdbcType=VARCHAR}, ",
        "#{slStartringno,jdbcType=INTEGER}, #{slRingnum,jdbcType=INTEGER}, ",
        "#{slLength,jdbcType=REAL}, #{slJhgq,jdbcType=INTEGER}, #{slPrefix,jdbcType=VARCHAR}, ",
        "#{gmtCreate,jdbcType=TIMESTAMP}, #{gmtModified,jdbcType=TIMESTAMP}, ",
        "#{sInfoid,jdbcType=VARCHAR}, #{slDesc,jdbcType=LONGVARCHAR})"
    })
    int insert(Iris_Pro_Sec_Line record);

    @InsertProvider(type=Iris_Pro_Sec_LineSqlProvider.class, method="insertSelective")
    int insertSelective(Iris_Pro_Sec_Line record);

    @Select({
        "select",
        "id, s_id, sl_name, sl_se_mileage, sl_se_position, sl_startringno, sl_ringnum, ",
        "sl_length, sl_jhgq, sl_prefix, gmt_create, gmt_modified, s_infoId, sl_desc",
        "from iris_pro_sec_line",
        "where id = #{id,jdbcType=CHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="s_id", property="sId", jdbcType=JdbcType.CHAR),
        @Result(column="sl_name", property="slName", jdbcType=JdbcType.VARCHAR),
        @Result(column="sl_se_mileage", property="slSeMileage", jdbcType=JdbcType.VARCHAR),
        @Result(column="sl_se_position", property="slSePosition", jdbcType=JdbcType.VARCHAR),
        @Result(column="sl_startringno", property="slStartringno", jdbcType=JdbcType.INTEGER),
        @Result(column="sl_ringnum", property="slRingnum", jdbcType=JdbcType.INTEGER),
        @Result(column="sl_length", property="slLength", jdbcType=JdbcType.REAL),
        @Result(column="sl_jhgq", property="slJhgq", jdbcType=JdbcType.INTEGER),
        @Result(column="sl_prefix", property="slPrefix", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modified", property="gmtModified", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="s_infoId", property="sInfoid", jdbcType=JdbcType.VARCHAR),
        @Result(column="sl_desc", property="slDesc", jdbcType=JdbcType.LONGVARCHAR)
    })
    Iris_Pro_Sec_Line selectByPrimaryKey(String id);

    @UpdateProvider(type=Iris_Pro_Sec_LineSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Iris_Pro_Sec_Line record);

    @Update({
        "update iris_pro_sec_line",
        "set s_id = #{sId,jdbcType=CHAR},",
          "sl_name = #{slName,jdbcType=VARCHAR},",
          "sl_se_mileage = #{slSeMileage,jdbcType=VARCHAR},",
          "sl_se_position = #{slSePosition,jdbcType=VARCHAR},",
          "sl_startringno = #{slStartringno,jdbcType=INTEGER},",
          "sl_ringnum = #{slRingnum,jdbcType=INTEGER},",
          "sl_length = #{slLength,jdbcType=REAL},",
          "sl_jhgq = #{slJhgq,jdbcType=INTEGER},",
          "sl_prefix = #{slPrefix,jdbcType=VARCHAR},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modified = #{gmtModified,jdbcType=TIMESTAMP},",
          "s_infoId = #{sInfoid,jdbcType=VARCHAR},",
          "sl_desc = #{slDesc,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=CHAR}"
    })
    int updateByPrimaryKeyWithBLOBs(Iris_Pro_Sec_Line record);

    @Update({
        "update iris_pro_sec_line",
        "set s_id = #{sId,jdbcType=CHAR},",
          "sl_name = #{slName,jdbcType=VARCHAR},",
          "sl_se_mileage = #{slSeMileage,jdbcType=VARCHAR},",
          "sl_se_position = #{slSePosition,jdbcType=VARCHAR},",
          "sl_startringno = #{slStartringno,jdbcType=INTEGER},",
          "sl_ringnum = #{slRingnum,jdbcType=INTEGER},",
          "sl_length = #{slLength,jdbcType=REAL},",
          "sl_jhgq = #{slJhgq,jdbcType=INTEGER},",
          "sl_prefix = #{slPrefix,jdbcType=VARCHAR},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modified = #{gmtModified,jdbcType=TIMESTAMP},",
          "s_infoId = #{sInfoid,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=CHAR}"
    })
    int updateByPrimaryKey(Iris_Pro_Sec_Line record);
}