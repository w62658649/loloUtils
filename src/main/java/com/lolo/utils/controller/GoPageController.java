package com.lolo.utils.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/go")
public class GoPageController {

	

	@RequestMapping(value = "test")
	public String getGoTest(){
		Map<String, Object> result = new HashMap<String, Object>();
		
		return "test";
	}
	
	@RequestMapping(value = "zip")
	public String getGoZip(){
		Map<String, Object> result = new HashMap<String, Object>();
		
		return "zipcode";
	}
	
}
