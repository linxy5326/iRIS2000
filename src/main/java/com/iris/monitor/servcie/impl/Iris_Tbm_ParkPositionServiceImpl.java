
/**
 * 描述：
 * 叶辉 2017年11月15日 
 */
package com.iris.monitor.servcie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iris.monitor.entity.Iris_Tbm_ParkPosition;
import com.iris.monitor.mapper.Iris_Tbm_ParkPositionMapper;
import com.iris.monitor.servcie.Iris_Tbm_ParkPositionService;

@Service
public class Iris_Tbm_ParkPositionServiceImpl implements Iris_Tbm_ParkPositionService{
	
	@Autowired
	private final Iris_Tbm_ParkPositionMapper parkPositionDao;
	
	public Iris_Tbm_ParkPositionServiceImpl(Iris_Tbm_ParkPositionMapper  parkPositionDao)
	{
		this.parkPositionDao=parkPositionDao;
	}
	
	
	/*
	 * 根据Id  查询盾构机停放场地信息
	 * @param id  记录唯一标识符
	 * @return 盾构机停放场地信息实体
	 * */
	
	@Override
	public Iris_Tbm_ParkPosition findParkPositionById(int id)
	{
		return parkPositionDao.selectByPrimaryKey(id);
	}
}