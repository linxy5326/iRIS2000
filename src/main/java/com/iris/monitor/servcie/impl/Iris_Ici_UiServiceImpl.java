
/**
 * 描述：
 * 叶辉 2017年11月15日 
 */
package com.iris.monitor.servcie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iris.monitor.entity.Iris_Ici_Ui;
import com.iris.monitor.mapper.Iris_Ici_UiMapper;
import com.iris.monitor.servcie.Iris_Ici_UiService;

@Service
public class Iris_Ici_UiServiceImpl implements Iris_Ici_UiService{
	
	@Autowired
	private final Iris_Ici_UiMapper IciUiDao;
	
	public Iris_Ici_UiServiceImpl(Iris_Ici_UiMapper  IciUiDao)
	{
		this.IciUiDao=IciUiDao;
	}
	
	
	/*
	 * 根据Id  查询盾构区间线路和盾构机信息
	 * @param id  记录唯一标识符
	 * @return 盾构区间线路和盾构机实体
	 * */
	
	@Override
	public Iris_Ici_Ui findIciUiById(int id)
	{
		return IciUiDao.selectByPrimaryKey(id);
	}
}