package com.iris.monitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iris.monitor.entity.Iris_Pro_Iop;
import com.iris.monitor.servcie.Iris_Pro_IopService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/ProIop")
public class ProIopController {
	
	@Autowired
    private Iris_Pro_IopService proIopService;

	@ApiOperation(value="盾构机IO变量详细信息", notes="根据url的id来获取盾构机IO变量详细信息")
	@ApiImplicitParam(name = "id", value = "盾构机IO变量ID", required = true,paramType="path",  dataType = "Int")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Iris_Pro_Iop fineProIopInfo(@PathVariable("id") int id){
		return proIopService.findProIopById(id);
	}
}