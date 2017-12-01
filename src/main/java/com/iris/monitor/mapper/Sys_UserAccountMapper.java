package com.iris.monitor.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import com.iris.monitor.entity.Sys_UserAccount;

public interface Sys_UserAccountMapper {
	@Delete({ "delete from sys_useraccount", "where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	@Insert({ "insert into sys_useraccount (id, ua_name, ", "ua_email, ua_pwd, ", "ua_nickname, ua_status, ",
			"ua_regdate, ua_expirydate, ", "ua_desc, ua_group, ", "gmt_create, gmt_modified, ", "is_deleted, u_id, ",
			"app_id)", "values (#{id,jdbcType=INTEGER}, #{uaName,jdbcType=VARCHAR}, ",
			"#{uaEmail,jdbcType=VARCHAR}, #{uaPwd,jdbcType=VARCHAR}, ",
			"#{uaNickname,jdbcType=VARCHAR}, #{uaStatus,jdbcType=TINYINT}, ",
			"#{uaRegdate,jdbcType=TIMESTAMP}, #{uaExpirydate,jdbcType=TIMESTAMP}, ",
			"#{uaDesc,jdbcType=VARCHAR}, #{uaGroup,jdbcType=VARCHAR}, ",
			"#{gmtCreate,jdbcType=TIMESTAMP}, #{gmtModified,jdbcType=TIMESTAMP}, ",
			"#{isDeleted,jdbcType=TINYINT}, #{uId,jdbcType=INTEGER}, ", "#{appId,jdbcType=VARCHAR})" })
	int insert(Sys_UserAccount record);

	@InsertProvider(type = Sys_UserAccountSqlProvider.class, method = "insertSelective")
	int insertSelective(Sys_UserAccount record);

	@Select({ "select", "id, ua_name, ua_email, ua_pwd, ua_nickname, ua_status, ua_regdate, ua_expirydate, ",
			"ua_desc, ua_group, gmt_create, gmt_modified, is_deleted, u_id, app_id", "from sys_useraccount",
			"where id = #{id,jdbcType=INTEGER}" })
	@Results({ @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "ua_name", property = "uaName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "ua_email", property = "uaEmail", jdbcType = JdbcType.VARCHAR),
			@Result(column = "ua_pwd", property = "uaPwd", jdbcType = JdbcType.VARCHAR),
			@Result(column = "ua_nickname", property = "uaNickname", jdbcType = JdbcType.VARCHAR),
			@Result(column = "ua_status", property = "uaStatus", jdbcType = JdbcType.TINYINT),
			@Result(column = "ua_regdate", property = "uaRegdate", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "ua_expirydate", property = "uaExpirydate", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "ua_desc", property = "uaDesc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "ua_group", property = "uaGroup", jdbcType = JdbcType.VARCHAR),
			@Result(column = "gmt_create", property = "gmtCreate", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "gmt_modified", property = "gmtModified", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "is_deleted", property = "isDeleted", jdbcType = JdbcType.TINYINT),
			@Result(column = "u_id", property = "uId", jdbcType = JdbcType.INTEGER),
			@Result(column = "app_id", property = "appId", jdbcType = JdbcType.VARCHAR) })
	Sys_UserAccount selectByPrimaryKey(Integer id);

	@Select({ "select", "id, ua_name, ua_email, ua_nickname, ua_status, ua_regdate, ua_expirydate, ",
			"ua_desc, ua_group, gmt_create, gmt_modified, is_deleted, u_id, app_id", "from sys_useraccount",
			"where ua_name = #{arg0} and ua_pwd=#{arg1}" })
	@Results({ @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "ua_name", property = "uaName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "ua_email", property = "uaEmail", jdbcType = JdbcType.VARCHAR),
			@Result(column = "ua_pwd", property = "uaPwd", jdbcType = JdbcType.VARCHAR),
			@Result(column = "ua_nickname", property = "uaNickname", jdbcType = JdbcType.VARCHAR),
			@Result(column = "ua_status", property = "uaStatus", jdbcType = JdbcType.TINYINT),
			@Result(column = "ua_regdate", property = "uaRegdate", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "ua_expirydate", property = "uaExpirydate", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "ua_desc", property = "uaDesc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "ua_group", property = "uaGroup", jdbcType = JdbcType.VARCHAR),
			@Result(column = "gmt_create", property = "gmtCreate", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "gmt_modified", property = "gmtModified", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "is_deleted", property = "isDeleted", jdbcType = JdbcType.TINYINT),
			@Result(column = "u_id", property = "uId", jdbcType = JdbcType.INTEGER),
			@Result(column = "app_id", property = "appId", jdbcType = JdbcType.VARCHAR) })
	Sys_UserAccount selectByNameAndPass(String ua_name, String ua_pwd);

	@UpdateProvider(type = Sys_UserAccountSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(Sys_UserAccount record);

	@Update({ "update sys_useraccount", "set ua_name = #{uaName,jdbcType=VARCHAR},",
			"ua_email = #{uaEmail,jdbcType=VARCHAR},", "ua_pwd = #{uaPwd,jdbcType=VARCHAR},",
			"ua_nickname = #{uaNickname,jdbcType=VARCHAR},", "ua_status = #{uaStatus,jdbcType=TINYINT},",
			"ua_regdate = #{uaRegdate,jdbcType=TIMESTAMP},", "ua_expirydate = #{uaExpirydate,jdbcType=TIMESTAMP},",
			"ua_desc = #{uaDesc,jdbcType=VARCHAR},", "ua_group = #{uaGroup,jdbcType=VARCHAR},",
			"gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},", "gmt_modified = #{gmtModified,jdbcType=TIMESTAMP},",
			"is_deleted = #{isDeleted,jdbcType=TINYINT},", "u_id = #{uId,jdbcType=INTEGER},",
			"app_id = #{appId,jdbcType=VARCHAR}", "where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(Sys_UserAccount record);
}