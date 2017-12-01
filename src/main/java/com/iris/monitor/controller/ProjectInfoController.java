package com.iris.monitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iris.monitor.entity.Iris_Project;
import com.iris.monitor.servcie.Iris_ProjectService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/ProInfo")
public class ProjectInfoController {
	
	@Autowired
    private Iris_ProjectService proService;

	@ApiOperation(value="盾构项目详细信息", notes="根据url的id来获取盾构项目详细信息")
	@ApiImplicitParam(name = "id", value = "盾构项目ID", required = true,paramType="path",  dataType = "String")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Iris_Project fineProjectInfo(@PathVariable("id") String id){
		return proService.findProInfoById(id);
	}
}