package com.iris.monitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iris.monitor.entity.Iris_TbmInfo;
import com.iris.monitor.servcie.Iris_TbmInfoService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/Tbm")
public class TbmInfoController {
	
	@Autowired
    private Iris_TbmInfoService resService;

	@ApiOperation(value="盾构机详细信息", notes="根据url的id来获取盾构机详细信息")
	@ApiImplicitParam(name = "id", value = "盾构机信息ID", required = true,paramType="path",  dataType = "String")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Iris_TbmInfo fineTbmInfo(@PathVariable("id") String id){
		return resService.findTbmInfoById(id);
	}
}