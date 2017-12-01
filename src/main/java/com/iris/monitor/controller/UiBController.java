
package com.iris.monitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iris.monitor.entity.Iris_Ui_B;
import com.iris.monitor.servcie.Iris_Ui_BService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/UiB")
public class UiBController {
	
	@Autowired
    private Iris_Ui_BService uibService;

	@ApiOperation(value="盾构机界面变量详细信息", notes="根据url的id来获取盾构机界面变量详细信息")
	@ApiImplicitParam(name = "id", value = "盾构机界面变量ID", required = true,paramType="path",  dataType = "Int")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Iris_Ui_B fineUIBInfo(@PathVariable("id") int id){
		return uibService.findUiBLById(id);
	}
}