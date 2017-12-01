package com.iris.monitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iris.monitor.entity.Sys_ResourceInfo;
import com.iris.monitor.servcie.Sys_ResourceInfoService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/Res")
public class ResInfoController {
	
	@Autowired
    private Sys_ResourceInfoService resService;

	@ApiOperation(value="系统资源详细信息", notes="根据url的id来获取系统资源详细信息")
	@ApiImplicitParam(name = "id", value = "系统资源ID", required = true,paramType="path",  dataType = "Int")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Sys_ResourceInfo fineResourceInfo(@PathVariable("id") int id){
		return resService.findResInfoById(id);
	}
}