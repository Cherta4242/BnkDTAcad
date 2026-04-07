package com.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@GetMapping("/dashboard")
	public ResponseEntity<Map<String, String>> dashboard(Authentication authentication){
		return ResponseEntity.ok(Map.of("message", "OK! 관리자 대시보드 - " + authentication.getName()));
		
	}
	
	@GetMapping("/users")
	public ResponseEntity<Map<String, Object>>users(){
		return ResponseEntity.ok(Map.of("message", "OK! 전체 회원목록", "users", List.of("user1", "user2", "user3")));
	}
	
}
