package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.dto.MemberDto;
import com.example.entity.Member;
import com.example.repository.MemberRepository;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;
	@Autowired // Bean 등록
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public Member regist(MemberDto memberDto) {

		Member member = new Member();
//		Dto -> Entity + Pw 암호화
		member.setUsername(memberDto.getUsername());
		String newPw = bCryptPasswordEncoder.encode(memberDto.getPassword());
		member.setPassword(newPw);
		member.setName(memberDto.getName());
		member.setEmail(memberDto.getEmail());
		if (memberDto.getUsername().equals("admin"))
			member.setRole("ROLE_ADMIN");
		else
			member.setRole("ROLE_MEMBER");

		return memberRepository.save(member);
	}

}
