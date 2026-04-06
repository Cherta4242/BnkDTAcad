package com.example.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins ="*")
@RestController
public class HellController {
	
	@GetMapping("/hello")
	public String hello() {
		return "hello World";
	}
}
