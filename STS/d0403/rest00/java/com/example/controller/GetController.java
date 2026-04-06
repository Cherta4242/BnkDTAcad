package com.example.controller;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.Member;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {
	
//	http://localhost:8080/api/v1/get-api/hello
	@GetMapping("/hello")
	public String getHello() {
		return "Hello World - API!";
	}
	
//	http://localhost:8080/api/v1/get-api/request1?name=value1&email=value2&organization=value3
	@GetMapping("/request1")
	public String getRequest1(
			@RequestParam("name")String name,
			@RequestParam("email")String email,
			@RequestParam("organization")String organization,
			ArrayList<String> list){
		
		list.add("이름: " + name);
		list.add("이메일: " + email);
		list.add("회사: " + organization);
		
		return list.toString();
	}
	
//	http://localhost:8080/api/v1/get-api/request2/{variable}
	@GetMapping("/request2/{variable}")
	public String getRequest2(@PathVariable("variable") String variable) {
		
		return "받은 값: " + variable;
	}
	
//	http://localhost:8080/api/v1/get-api/request3?name=value1&email=value2&organization=value3
	@GetMapping("/request3")
	public String getparamMap(@RequestParam Map<String, String> param) {
		Set<String> keys = param.keySet();
		for(String key : keys) {
			param.get(key);
		}
		
		StringBuilder sb = new StringBuilder();	// StringBuilder -> 가변객체
		param.entrySet().forEach(map -> {
			sb.append(map.getKey() + ": " + map.getValue() + "\n");
		});
		
		return sb.toString();
	}
	
	
//	http://localhost:8080/api/v1/get-api/request4?name=value1&email=value2&organization=value3	
	@GetMapping("/request4")
	public String getDto(Member dto) {
		return "name: " + dto.getName() + "\n"
				+ "email: " + dto.getEmail() + "\n"
				+ "organization: " + dto.getOrganization() + "\n";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
