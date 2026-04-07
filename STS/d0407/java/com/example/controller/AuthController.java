package com.example.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwt.JwtUtil;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthController {
	
	private final JwtUtil jwtUtil;
	
	@PostMapping("/login")
	public ResponseEntity<Map<String, String>> login(
			@RequestBody Map<String, String> body,
			HttpServletResponse response){
		
		String username = body.get("username");
		String password = body.get("password");
		String role = body.get("role");
		
		if(!"1234".equals(password)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
								 .body(Map.of("mesage", "Oops! 아이디 또는 비밀번호가 틀렸어요!"));
		}
		
//		토큰 생성
		String token = jwtUtil.generateToken(username, role);
		
//		응답 헤더에 토큰 세팅
		response.setHeader("Authorization",  "Bearer " + token);
		System.out.println("로그인에 사용된 토큰: " + token);
		return ResponseEntity.ok(Map.of("Message", "로그인 성공! 응답 헤더의 Authorization 값을 다음 요청에 사용하세요."));
	}
}
