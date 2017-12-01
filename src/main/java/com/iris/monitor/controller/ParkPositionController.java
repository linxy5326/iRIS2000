package com.iris.monitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iris.monitor.entity.Iris_Tbm_ParkPosition;
import com.iris.monitor.servcie.Iris_Tbm_ParkPositionService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/ParkPosition")
public class ParkPositionController {
	
	@Autowired
    private Iris_Tbm_ParkPositionService positionService;

	@ApiOperation(value="盾构机停放场地详细信息", notes="根据url的id来获取盾构机停放场地详细信息")
	@ApiImplicitParam(name = "id", value = "盾构机停放场地ID", required = true,paramType="path",  dataType = "Int")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Iris_Tbm_ParkPosition fineParkPositionInfo(@PathVariable("id") int id){
		return positionService.findParkPositionById(id);
	}
}