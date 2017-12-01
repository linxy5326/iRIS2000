package com.iris.monitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iris.monitor.entity.Iris_Ui_IoMap;
import com.iris.monitor.servcie.Iris_Ui_IoMapService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/IoMap")
public class UiMapController {
	
	@Autowired
    private Iris_Ui_IoMapService uiMapService;

	@ApiOperation(value="盾构机界面变量映射详细信息", notes="根据url的id来获取盾构机界面变量映射详细信息")
	@ApiImplicitParam(name = "id", value = "盾构机界面变量映射ID", required = true,paramType="path",  dataType = "Int")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Iris_Ui_IoMap fineUiIoMap(@PathVariable("id") int id){
		return uiMapService.findIOMapById(id);
	}
}