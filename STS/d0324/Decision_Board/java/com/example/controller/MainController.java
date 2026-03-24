package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	
	// index 페이지 접속
	@GetMapping("/")
	public String root() {
		return "index";
	}
	
	
}
