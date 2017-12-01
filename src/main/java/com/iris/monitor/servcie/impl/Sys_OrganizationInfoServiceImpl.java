
/**
 * 描述：
 * 叶辉 2017年11月15日 
 */
package com.iris.monitor.servcie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iris.monitor.entity.Sys_OrganizationInfo;
import com.iris.monitor.mapper.Sys_OrganizationInfoMapper;
import com.iris.monitor.servcie.Sys_OrganizationInfoService;

@Service
public class Sys_OrganizationInfoServiceImpl implements Sys_OrganizationInfoService{
	
	@Autowired
	private final Sys_OrganizationInfoMapper orgInfoDao;
	
	public Sys_OrganizationInfoServiceImpl(Sys_OrganizationInfoMapper  orgInfoDao)
	{
		this.orgInfoDao=orgInfoDao;
	}
	
	/*
	 * 根据Id  查询组织机构信息
	 * @param id  记录唯一标识符
	 * @return  系统资源实体
	 * */
	
	@Override
	public Sys_OrganizationInfo findOrgInfoById(String id)
	{
		return orgInfoDao.selectByPrimaryKey(id);
	}
}