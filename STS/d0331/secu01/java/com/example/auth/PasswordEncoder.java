package com.example.auth;

import org.springframework.stereotype.Component;

@Component
public class PasswordEncoder {
	// 비밀번호 암호화 하기
	
	public String passwordEncoder(String password) {
		String encode = "";
		
		for(int i=0; i < password.length(); i++) {
			encode += password.charAt(i) + 1;
		}
		
		
		return encode;
	}
}
