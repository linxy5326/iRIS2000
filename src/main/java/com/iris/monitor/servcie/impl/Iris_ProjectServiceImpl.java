

/**
 * 描述：
 * 叶辉 2017年11月15日 
 */
package com.iris.monitor.servcie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iris.monitor.entity.Iris_Project;
import com.iris.monitor.mapper.Iris_ProjectMapper;
import com.iris.monitor.servcie.Iris_ProjectService;

@Service
public class Iris_ProjectServiceImpl implements Iris_ProjectService{
	
	@Autowired
	private final Iris_ProjectMapper proInfoDao;
	
	public Iris_ProjectServiceImpl(Iris_ProjectMapper  proInfoDao)
	{
		this.proInfoDao=proInfoDao;
	}
	
	
	/*
	 * 根据Id  查询盾构项目信息
	 * @param id  记录唯一标识符
	 * @return 盾构项目信息实体
	 * */
	
	@Override
	public Iris_Project findProInfoById(String id)
	{
		return proInfoDao.selectByPrimaryKey(id);
	}
}