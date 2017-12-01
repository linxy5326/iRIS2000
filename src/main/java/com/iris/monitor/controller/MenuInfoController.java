package com.iris.monitor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iris.monitor.entity.Sys_MenuInfo;
import com.iris.monitor.servcie.Sys_MenuInfoService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/MenuInfo")
public class MenuInfoController {
	
	@Autowired
    private Sys_MenuInfoService menuService;

	@ApiOperation(value="系统菜单详细信息", notes="根据url的id来获取系统菜单详细信息")
	@ApiImplicitParam(name = "id", value = "系统菜单ID", required = true,paramType="path",  dataType = "String")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Sys_MenuInfo fineMenuInfo(@PathVariable("id") int id){
		return menuService.findMenuInfoById(id);
	}
	
	@ApiOperation(value="系统菜单列表", notes="获取系统菜单详细信息")
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Sys_MenuInfo> findAllMenuInfo(){
		return menuService.findMenuInfos();
	}

}