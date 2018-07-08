package com.sspace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FirstBootController {

	@RequestMapping(value="/hello")
	public String firsrUrl(){
		return "hello";
	}
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String showLogin(){
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String processLogin(){
		return "home";
	}
	
}
