
/**
 * 描述：
 * 叶辉 2017年11月15日 
 */
package com.iris.monitor.servcie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iris.monitor.entity.Iris_Pro_Section;
import com.iris.monitor.mapper.Iris_Pro_SectionMapper;
import com.iris.monitor.servcie.Iris_Pro_SectionService;

@Service
public class Iris_Pro_SectionServiceImpl implements Iris_Pro_SectionService{
	
	@Autowired
	private final Iris_Pro_SectionMapper proSectionDao;
	
	public Iris_Pro_SectionServiceImpl(Iris_Pro_SectionMapper  proSectionDao)
	{
		this.proSectionDao=proSectionDao;
	}
	
	
	/*
	 * 根据Id  查询盾构项目区间信息
	 * @param id  记录唯一标识符
	 * @return 盾构项目区间信息实体
	 * */
	
	@Override
	public Iris_Pro_Section findProSectionById(String id)
	{
		return proSectionDao.selectByPrimaryKey(id);
	}
}