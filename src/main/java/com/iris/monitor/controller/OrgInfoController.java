package com.iris.monitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iris.monitor.entity.Sys_OrganizationInfo;
import com.iris.monitor.servcie.Sys_OrganizationInfoService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/OrgInfo")
public class OrgInfoController {
	
	@Autowired
    private Sys_OrganizationInfoService orgInfoService;

	@ApiOperation(value="组织机构详细信息", notes="根据url的id来获取组织机构详细信息")
	@ApiImplicitParam(name = "id", value = "组织机构ID", required = true,paramType="path",  dataType = "String")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Sys_OrganizationInfo fineOrgInfo(@PathVariable("id") String id){
		return orgInfoService.findOrgInfoById(id);
	}
}