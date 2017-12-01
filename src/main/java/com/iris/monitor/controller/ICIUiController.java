package com.iris.monitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iris.monitor.entity.Iris_Ici_Ui;
import com.iris.monitor.servcie.Iris_Ici_UiService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value="/api/ICIUi")
public class ICIUiController {

	@Autowired
	private Iris_Ici_UiService iciUiService;
	
	 @ApiOperation(value="获取盾构机监控界面信息", notes="根据url的id来获取盾构机监控界面详细信息")
	@ApiImplicitParam(name = "id", value = "盾构机监控界面信息ID", required = true,paramType="path",  dataType = "Int")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Iris_Ici_Ui findIciUiInfo(@PathVariable("id") int id)
	{
		return iciUiService.findIciUiById(id);
	}
}