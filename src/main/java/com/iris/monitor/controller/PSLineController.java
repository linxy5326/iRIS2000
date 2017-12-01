package com.iris.monitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iris.monitor.entity.Iris_Pro_Sec_Line;
import com.iris.monitor.servcie.Iris_Pro_Sec_LineService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/ProLine")
public class PSLineController {
	
	@Autowired
    private Iris_Pro_Sec_LineService proSecService;

	@ApiOperation(value="盾构项目区间线路详细信息", notes="根据url的id来获取盾构项目区间详细信息")
	@ApiImplicitParam(name = "id", value = "盾构项目区间线路ID", required = true,paramType="path",  dataType = "String")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Iris_Pro_Sec_Line fineProLine(@PathVariable("id") String id){
		return proSecService.findSecLineById(id);
	}
}