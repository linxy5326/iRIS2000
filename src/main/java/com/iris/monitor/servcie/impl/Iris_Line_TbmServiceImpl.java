
/**
 * 描述：
 * 叶辉 2017年11月15日 
 */
package com.iris.monitor.servcie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iris.monitor.entity.Iris_Line_Tbm;
import com.iris.monitor.mapper.Iris_Line_TbmMapper;
import com.iris.monitor.servcie.Iris_Line_TbmService;

@Service
public class Iris_Line_TbmServiceImpl implements Iris_Line_TbmService{
	
	@Autowired
	private final Iris_Line_TbmMapper tbmLineDao;
	
	public Iris_Line_TbmServiceImpl(Iris_Line_TbmMapper  tbmLineDao)
	{
		this.tbmLineDao=tbmLineDao;
	}
	
	
	/*
	 * 根据Id  查询盾构区间线路和盾构机信息
	 * @param id  记录唯一标识符
	 * @return 盾构区间线路和盾构机实体
	 * */
	
	@Override
	public Iris_Line_Tbm findLineTbmById(int id)
	{
		return tbmLineDao.selectByPrimaryKey(id);
	}
}