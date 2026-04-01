package com.example.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class AuthSession {
	
	private Map<String, MemberDetails> session = new HashMap<>();
	
	public void setAttribute(String username, MemberDetails memberDetails) {
		// 세션에 등록하기
		session.put(username, memberDetails);
		
	}
	
	public MemberDetails getAttribute(String username) {
		// 세션에서 Member 정보 얻어내기
		return session.get(username);
	}
	
	public void remoceAttribute(String username) {
		// 세션에서 지우기
		session.remove(username);
		
	}
	
	
	public void invalidate() {
		// 세션 내용 비우기
		session.clear();
		
	}
	
}
