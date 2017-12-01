
/**
 * 描述：
 * 叶辉 2017年11月15日 
 */
package com.iris.monitor.servcie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iris.monitor.entity.Iris_TbmInfo;
import com.iris.monitor.mapper.Iris_TbmInfoMapper;
import com.iris.monitor.servcie.Iris_TbmInfoService;

@Service
public class  Iris_TbmInfoServiceImpl implements Iris_TbmInfoService{
	
	@Autowired
	private final Iris_TbmInfoMapper tbmInfoDao;
	
	public Iris_TbmInfoServiceImpl(Iris_TbmInfoMapper  tbmInfoDao)
	{
		this.tbmInfoDao=tbmInfoDao;
	}
	
	
	/*
	 * 根据Id  查询盾构机信息
	 * @param id  记录唯一标识符
	 * @return  盾构机信息实体
	 * */
	
	@Override
	public Iris_TbmInfo findTbmInfoById(String id)
	{
		return tbmInfoDao.selectByPrimaryKey(id);
	}
}