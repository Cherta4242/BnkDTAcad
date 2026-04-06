package com.example.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.Member;

	

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

//	http://localhost:8080/api/v1/post-api/member
	@PostMapping("/member")
	public String postMember(@RequestBody Map<String, Object> postData) {		
		
		StringBuilder sb = new StringBuilder();
		postData.entrySet().forEach(map -> {
			sb.append(map.getKey() + " : " + map.getValue() + "\n");
		});
		
		return sb.toString();
	}
	
	
//	http://localhost:8080/api/v1/post-api/member2
	@PostMapping("/member2")
	public Member postMember2(@RequestBody Member member) {
		System.out.println("===============");
		System.out.println("이름 받아지나 테스트: " + member.getName());
		return member;
	}
	
	
	
	
	
	
	
}
