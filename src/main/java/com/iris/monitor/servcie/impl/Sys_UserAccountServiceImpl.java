
/**
 * 描述：
 * 叶辉 2017年11月15日 
 */
package com.iris.monitor.servcie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iris.monitor.entity.Sys_UserAccount;
import com.iris.monitor.mapper.Sys_UserAccountMapper;
import com.iris.monitor.servcie.Sys_UserAccountService;

@Service
public class Sys_UserAccountServiceImpl implements Sys_UserAccountService {

	@Autowired
	private final Sys_UserAccountMapper userAccountDao;

	public Sys_UserAccountServiceImpl(Sys_UserAccountMapper userAccountDao) {
		this.userAccountDao = userAccountDao;
	}

	/*
	 * 根据Id 查询用户账户信息
	 * 
	 * @param id 记录唯一标识符
	 * 
	 * @return 用户个性化信息实体
	 */

	@Override
	public Sys_UserAccount findUserAccountById(int id) {
		return userAccountDao.selectByPrimaryKey(id);
	}

	@Override
	public Sys_UserAccount findUserAccountByNameAndPassword(String name, String password) {

		// TODO 密码加密
		// return null;
		return userAccountDao.selectByNameAndPass(name, password);
	}
}