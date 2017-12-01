
/**
 * 描述：
 * 叶辉 2017年11月15日 
 */
package com.iris.monitor.servcie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.iris.monitor.entity.Sys_MenuInfo;
import com.iris.monitor.mapper.Sys_MenuInfoMapper;
import com.iris.monitor.servcie.Sys_MenuInfoService;

@Service
public class Sys_MenuInfoServiceImpl implements Sys_MenuInfoService{
	
	@Autowired
	private final Sys_MenuInfoMapper menuInfoDao;
	
	public Sys_MenuInfoServiceImpl(Sys_MenuInfoMapper  menuInfoDao)
	{
		this.menuInfoDao=menuInfoDao;
	}
	
	/*
	 * 根据Id  查询组织机构信息
	 * @param id  记录唯一标识符
	 * @return  系统资源实体
	 * */
	
	@Override
	public Sys_MenuInfo findMenuInfoById(int id)
	{
		return menuInfoDao.selectByPrimaryKey(id);
	}
	
	public List<Sys_MenuInfo> findMenuInfos(){
		return menuInfoDao.selectAllMenuInfo();
	}
}