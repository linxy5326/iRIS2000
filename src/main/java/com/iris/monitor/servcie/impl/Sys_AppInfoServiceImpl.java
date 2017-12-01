package com.iris.monitor.servcie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iris.monitor.entity.Sys_AppInfo;
import com.iris.monitor.mapper.Sys_AppInfoMapper;
import com.iris.monitor.servcie.Sys_AppInfoService;

@Service
public class Sys_AppInfoServiceImpl implements Sys_AppInfoService{
	
	@Autowired
	private final Sys_AppInfoMapper appmapper;
	
	public Sys_AppInfoServiceImpl(Sys_AppInfoMapper  appmapper)
	{
		this.appmapper=appmapper;
	}
	
	/*
	 * 根据Id  查询应用程序信息
	 * */
	
	@Override
	public Sys_AppInfo findAppInfoById(String id)
	{
		return appmapper.selectByPrimaryKey(id);
	}
}