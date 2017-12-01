
/**
 * 描述：
 * 叶辉 2017年11月15日 
 */
package com.iris.monitor.servcie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iris.monitor.entity.Iris_Ui_B;
import com.iris.monitor.mapper.Iris_Ui_BMapper;
import com.iris.monitor.servcie.Iris_Ui_BService;

@Service
public class Iris_Ui_BServiceImpl implements Iris_Ui_BService{
	
	@Autowired
	private final Iris_Ui_BMapper uiBLDao;
	
	public Iris_Ui_BServiceImpl(Iris_Ui_BMapper  uiBLDao)
	{
		this.uiBLDao=uiBLDao;
	}
	
	
	/*
	 * 根据Id  查询界面变量信息信息
	 * @param id  记录唯一标识符
	 * @return  界面变量映射信息实体
	 * */
	
	@Override
	public Iris_Ui_B findUiBLById(int id)
	{
		return uiBLDao.selectByPrimaryKey(id);
	}
}