package com.iris.monitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iris.monitor.common.MD5Utils;
import com.iris.monitor.entity.Sys_UserAccount;
import com.iris.monitor.servcie.Sys_UserAccountService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/UA")
public class UserAccountController {

	@Autowired
	private Sys_UserAccountService uaService;

	/**
	 * 根据用户账户Id 获取用户账户详细信息
	 */
	@ApiOperation(value = "用户账户详细信息", notes = "根据url的id来获取用户账户详细信息")
	@ApiImplicitParam(name = "id", value = "用户账户ID", required = true, paramType = "path", dataType = "Int")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Sys_UserAccount fineUserAccount(@PathVariable("id") int id) {
		return uaService.findUserAccountById(id);
	}

	/**
	 * 根据用户名和密码返回用户账户信息
	 * 
	 * @param name
	 * @param pwd
	 */
	@RequestMapping(value = "/{name}/{pwd}", method = RequestMethod.GET)
	public Sys_UserAccount fineUserAccount(@PathVariable String name, @PathVariable String pwd) {

		// 加密明文密码
		String ePwd = MD5Utils.getmd5String(pwd);

		return uaService.findUserAccountByNameAndPassword(name, ePwd);
	}
}