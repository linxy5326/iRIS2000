

/**
 * 描述：
 * 叶辉 2017年11月15日 
 */
package com.iris.monitor.servcie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iris.monitor.entity.Iris_Pro_Iop;
import com.iris.monitor.mapper.Iris_Pro_IopMapper;
import com.iris.monitor.servcie.Iris_Pro_IopService;

@Service
public class Iris_Pro_IopServiceImpl implements Iris_Pro_IopService{
	
	@Autowired
	private final Iris_Pro_IopMapper IopDao;
	
	public Iris_Pro_IopServiceImpl(Iris_Pro_IopMapper  IopDao)
	{
		this.IopDao=IopDao;
	}
	
	
	/*
	 * 根据Id  查询盾构项目区间信息
	 * @param id  记录唯一标识符
	 * @return 盾构项目区间信息实体
	 * */
	
	@Override
	public Iris_Pro_Iop findProIopById(int id)
	{
		return IopDao.selectByPrimaryKey(id);
	}
}