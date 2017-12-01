
/**
 * 描述：
 * 叶辉 2017年11月15日 
 */
package com.iris.monitor.servcie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iris.monitor.entity.Iris_Tbm_UiBind;
import com.iris.monitor.mapper.Iris_Tbm_UiBindMapper;
import com.iris.monitor.servcie.Iris_Tbm_UiBindService;

@Service
public class  Iris_Tbm_UiBindServiceImpl implements Iris_Tbm_UiBindService{
	
	@Autowired
	private final Iris_Tbm_UiBindMapper uiBindDao;
	
	public Iris_Tbm_UiBindServiceImpl(Iris_Tbm_UiBindMapper  uiBindDao)
	{
		this.uiBindDao=uiBindDao;
	}
	
	
	/*
	 * 根据Id  查询盾构机界面配置信息
	 * @param id  记录唯一标识符
	 * @return  盾构机界面配置实体
	 * */
	
	@Override
	public Iris_Tbm_UiBind findTbmUiBindById(int id)
	{
		return uiBindDao.selectByPrimaryKey(id);
	}
}