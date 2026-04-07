package com.example.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
public class MemberController {
	
	@GetMapping("/hello")
	public ResponseEntity<Map<String, String>> hello(Authentication authentication){
		String username = authentication.getName();
		return ResponseEntity.ok(Map.of("message", "OK! 안녕하세요, 멤버 " + username + "님"));
	}
	
	@GetMapping("/mypage")
	public ResponseEntity<Map<String, String>> mypage(Authentication authentication){
		
		return ResponseEntity.ok(Map.of("message", "OK!" + authentication.getName() + "님의 마이페이지입니다!"));
	}
	
	
	
}
