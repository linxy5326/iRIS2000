/**
 * 描述：
 * 叶辉 2017年11月15日 
 */
package com.iris.monitor.servcie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iris.monitor.entity.Iris_Ui_IoMap;
import com.iris.monitor.mapper.Iris_Ui_IoMapMapper;
import com.iris.monitor.servcie.Iris_Ui_IoMapService;

@Service
public class Iris_Ui_IoMapServiceImpl implements Iris_Ui_IoMapService{
	
	@Autowired
	private final Iris_Ui_IoMapMapper ioMapDao;
	
	public Iris_Ui_IoMapServiceImpl(Iris_Ui_IoMapMapper  ioMapDao)
	{
		this.ioMapDao=ioMapDao;
	}
	
	
	/*
	 * 根据Id  查询界面变量映射信息
	 * @param id  记录唯一标识符
	 * @return  界面变量映射信息实体
	 * */
	
	@Override
	public Iris_Ui_IoMap findIOMapById(int id)
	{
		return ioMapDao.selectByPrimaryKey(id);
	}
}