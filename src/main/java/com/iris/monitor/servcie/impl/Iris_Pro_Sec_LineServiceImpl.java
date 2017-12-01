
/**
 * 描述：
 * 叶辉 2017年11月15日 
 */
package com.iris.monitor.servcie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iris.monitor.entity.Iris_Pro_Sec_Line;
import com.iris.monitor.mapper.Iris_Pro_Sec_LineMapper;
import com.iris.monitor.servcie.Iris_Pro_Sec_LineService;

@Service
public class Iris_Pro_Sec_LineServiceImpl implements Iris_Pro_Sec_LineService{
	
	@Autowired
	private final Iris_Pro_Sec_LineMapper secLineDao;
	
	public Iris_Pro_Sec_LineServiceImpl(Iris_Pro_Sec_LineMapper  secLineDao)
	{
		this.secLineDao=secLineDao;
	}
	
	
	/*
	 * 根据Id  查询盾构区间线路信息
	 * @param id  记录唯一标识符
	 * @return 盾构区间线路实体
	 * */
	
	@Override
	public Iris_Pro_Sec_Line findSecLineById(String id)
	{
		return secLineDao.selectByPrimaryKey(id);
	}
}