package com.iris.monitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iris.monitor.entity.Sys_AppInfo;
import com.iris.monitor.servcie.Sys_AppInfoService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/AppInfo")
//是一类特殊的@Controller，它的返回值直接作为HTTP Response的Body部分返回给浏览器。
//@Controller并非直接将字符串返回给浏览器，而是寻找名字为返回值的模板进行渲染
public class AppInfoController {
	
	@Autowired
    private Sys_AppInfoService appInfoService;


	@ApiOperation(value="获取系统应用详细信息", notes="根据url的id来获取系统应用详细信息")
	@ApiImplicitParam(name = "id", value = "应用程序注册ID", required = true,paramType="path",  dataType = "String")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Sys_AppInfo findOneAppInfo(@PathVariable("id") String  id) {
        return appInfoService.findAppInfoById(id);
    }

/*
    @RequestMapping(value = "/api/city", method = RequestMethod.POST)
    public void createCity(@RequestBody City city) {
        cityService.saveCity(city);
    }

    @RequestMapping(value = "/api/city", method = RequestMethod.PUT)
    public void modifyCity(@RequestBody City city) {
        cityService.updateCity(city);
    }

    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.DELETE)
    public void modifyCity(@PathVariable("id") Long id) {
        cityService.deleteCity(id);
    }
    */
}