package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.dto.MemberDto;
import com.example.entity.Member;
import com.example.repository.MemberRepository;

@Service
public class JoinService {
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@Autowired
	MemberRepository memberRepository;
	
	public Member regist(MemberDto memberDto) {
		// 실제 DB에 저장하게 하는 메소드.
		Member member = new Member();
		member.setUsername(memberDto.getUsername());
		String newPw = bCryptPasswordEncoder.encode(memberDto.getPassword());
		member.setPassword(newPw);
		member.setName(memberDto.getName());
		member.setEmail(memberDto.getEmail());
		
		if(memberDto.getUsername().equals("admin")) {
			member.setRole("ROLE_ADMIN");
		}else {
			member.setRole("ROLE_MEMBER");
		}
		
		return memberRepository.save(member);
	}
	
}
