package com.iris.monitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iris.monitor.entity.Iris_Tbm_UiBind;
import com.iris.monitor.servcie.Iris_Tbm_UiBindService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/UiBind")
public class TbmUiBindController {
	
	@Autowired
    private Iris_Tbm_UiBindService uiBindService;

	@ApiOperation(value="盾构机界面配置详细信息", notes="根据url的id来获取盾构机界面配置详细信息")
	@ApiImplicitParam(name = "id", value = "盾构机界面配置ID", required = true,paramType="path",  dataType = "Int")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Iris_Tbm_UiBind fineUiBind(@PathVariable("id") int id){
		return uiBindService.findTbmUiBindById(id);
	}
}