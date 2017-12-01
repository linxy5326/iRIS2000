package com.iris.monitor.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/")
	public String index(HttpServletRequest request) {  
        //逻辑处理  
        //request.setAttribute("key", "hello world");  
		return "index.html";
    }
}
