package com.example.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberDaoAuthProvider {
	
	@Autowired
	private AuthSession session;
	
	@Autowired	
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	MemberDetailsService memberDetailService;
	
	public MemberDetails getMemberDetails(String username) {
		return session.getAttribute(username);
	}
	
	@SuppressWarnings("unused")
	public boolean loginCheck(String username, String password) {
		// 로그인 성공 시 세션에 등록
		MemberDetails memberDetails = memberDetailService.loadMemberByUsername(username);
		System.out.println(memberDetails.getUsername() + memberDetails.getPassword());
		if(memberDetails.getUsername().equals(username)) {
			if(memberDetails.getPassword().equals(passwordEncoder.passwordEncoder(password))) {
				session.setAttribute(username, memberDetails);
				return true;				
			}
		}
		
		return false;
	}
}
