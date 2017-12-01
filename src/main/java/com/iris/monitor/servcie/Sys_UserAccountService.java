package com.iris.monitor.servcie;

import com.iris.monitor.entity.Sys_UserAccount;

public interface Sys_UserAccountService {

	/*
	 * 根据ID 查询用户账户信息
	 * @param id
	 * */
	public Sys_UserAccount findUserAccountById(int id);
	
	public Sys_UserAccount findUserAccountByNameAndPassword(String name,String password);

}