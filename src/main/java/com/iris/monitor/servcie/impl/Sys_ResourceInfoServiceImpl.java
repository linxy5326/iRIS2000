
/**
 * 描述：
 * 叶辉 2017年11月15日 
 */
package com.iris.monitor.servcie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iris.monitor.entity.Sys_ResourceInfo;
import com.iris.monitor.mapper.Sys_ResourceInfoMapper;
import com.iris.monitor.servcie.Sys_ResourceInfoService;

@Service
public class Sys_ResourceInfoServiceImpl implements Sys_ResourceInfoService{
	
	@Autowired
	private final Sys_ResourceInfoMapper resourceInfoDao;
	
	public Sys_ResourceInfoServiceImpl(Sys_ResourceInfoMapper  resourceInfoDao)
	{
		this.resourceInfoDao=resourceInfoDao;
	}
	
	/*
	 * 根据Id  查询系统资源信息
	 * @param id  记录唯一标识符
	 * @return  系统资源实体
	 * */
	
	@Override
	public Sys_ResourceInfo findResInfoById(int id)
	{
		return resourceInfoDao.selectByPrimaryKey(id);
	}
}