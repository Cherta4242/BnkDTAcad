package com.example.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.LoginRequest;
import com.example.jwt.JwtUtil;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/jwt-test")
@RequiredArgsConstructor
public class JwtTestController {


	
	private final JwtUtil jwtUtil;


	
	@GetMapping("/generate")
	public Map<String, String> generate(
			@RequestParam("username")String username,
			@RequestParam("role")String role,
			HttpServletResponse response){
		log.info("generate............");
		
		String token = jwtUtil.generateToken(username, role);
		
		response.setHeader("Authorization", "Bearer " + token);
		log.info("Authorization 헤더 설정 확인 -> {}", response.getHeader("Authorization"));
		
		
		return Map.of("username", username, "role", role, "token", token);
	}
	
	@PostMapping("/generate2")
	public Map<String, String> generate2(
			@RequestBody LoginRequest loginRequest,
			HttpServletResponse response){
		
		log.info("Generate2 실행");
		
		String username = loginRequest.getUsername();
		String role = loginRequest.getRole();
		
		String token = jwtUtil.generateToken(username, role);
		System.out.println("token: " + token);
		
		response.setHeader("Authorization", "Bearer " + token);
		log.info("Authorization 헤더 설정 확인 -> {}", response.getHeader("Authorization"));
		
		
		return Map.of("username", username, "role", role, "token", token);
	}
	
}
