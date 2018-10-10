package com.batian.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@RequestMapping("/getUser")
	public Map<String,Object> getUser(){
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("name", "张三");
		result.put("age",18);
		return result;
	}
}
