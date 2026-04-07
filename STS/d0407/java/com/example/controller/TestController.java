package com.example.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	//@GetMapping("/")
	public String root() {
		return "test jwt";
	}
	
	//@GetMapping("/api")
	public String api() {
		return "api test";
	}
}
