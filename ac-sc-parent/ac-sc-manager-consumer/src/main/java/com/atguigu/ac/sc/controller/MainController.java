package com.atguigu.ac.sc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/main/index")
	public String  toIndex() {
		return "main";
	}
	
	
}
