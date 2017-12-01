package com.iris.monitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iris.monitor.entity.Iris_Line_Tbm;
import com.iris.monitor.servcie.Iris_Line_TbmService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/LineTbm")
public class LineTbmController {
	
	@Autowired
    private Iris_Line_TbmService tbmLineService;

	@ApiOperation(value="区间线路上施工盾构机详细信息", notes="根据url的id来获取区间线路上施工盾构机详细信息")
	@ApiImplicitParam(name = "id", value = "线路调配盾构机ID", required = true,paramType="path",  dataType = "Int")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Iris_Line_Tbm findLineTbmInfo(@PathVariable("id") int id){
		return tbmLineService.findLineTbmById(id);
	}

}