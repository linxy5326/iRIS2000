/**
 * 描述：
 * 叶辉 2017年11月15日 
 */
package com.iris.monitor.servcie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iris.monitor.entity.Sys_UserProfile;
import com.iris.monitor.mapper.Sys_UserProfileMapper;
import com.iris.monitor.servcie.Sys_UserProfileService;

@Service
public class Sys_UserProfileServiceImpl implements Sys_UserProfileService{
	
	@Autowired
	private final Sys_UserProfileMapper userProfileDao;
	
	public Sys_UserProfileServiceImpl(Sys_UserProfileMapper  userProfileDao)
	{
		this.userProfileDao=userProfileDao;
	}
	
	/*
	 * 根据Id  查询用户个性化信息
	 * @param id  记录唯一标识符
	 * @return  用户个性化信息实体
	 * */
	
	@Override
	public Sys_UserProfile findProfileById(int id)
	{
		return userProfileDao.selectByPrimaryKey(id);
	}
}