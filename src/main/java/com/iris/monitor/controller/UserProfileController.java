package com.iris.monitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iris.monitor.entity.Sys_UserProfile;
import com.iris.monitor.servcie.Sys_UserProfileService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/Profile")
public class UserProfileController {
	
	@Autowired
    private Sys_UserProfileService profileService;

	@ApiOperation(value="用户账户个性化详细信息", notes="根据url的id来获取用户账户个性化详细信息")
	@ApiImplicitParam(name = "id", value = "用户账户个性化ID", required = true,paramType="path",  dataType = "Int")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Sys_UserProfile fineUserProfile(@PathVariable("id") int id){
		return profileService.findProfileById(id);
	}
}