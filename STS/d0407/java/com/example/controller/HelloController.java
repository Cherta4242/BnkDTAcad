package com.example.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwt.JwtUtil;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class HelloController {

	private final JwtUtil jwtUtil;
	
	@GetMapping("/api/hello")
	public ResponseEntity<Map<String, String>> hello(HttpServletRequest request){
		
		//필터를 통과했다면 토큰은 이미 검증된 상태이다.
		String token = request.getHeader("Authorization").substring(7);
		String username = jwtUtil.getUsername(token);
		
		
		return ResponseEntity.ok(Map.of("message", "OK! 환영합니다, " + username + "님"));
	}
}
