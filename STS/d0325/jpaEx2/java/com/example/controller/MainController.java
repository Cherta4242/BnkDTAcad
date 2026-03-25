package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dto.MemberDto;
import com.example.entity.MemberEntity;
import com.example.repository.MemberRepository;
import com.example.repository.MemoRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

	@Autowired
	MemberRepository memberRepository;
	@Autowired
	MemoRepository memoRepository;
	
	@GetMapping("/regForm")
	public String regForm() {
		return "regForm";
	}
	
	@SuppressWarnings("null")
	@PostMapping("/regist")
	public String regist(MemberDto dto) {
		MemberEntity member = new MemberEntity();
		System.out.println(dto);
		
		member.setUsername(dto.getUsername());
		member.setUserword(dto.getUserword());
		member.setNickname(dto.getNickname());
		
		System.out.println(member);
		
		memberRepository.save(member);
		return "success";
	}
	
	
	@GetMapping("/loginForm")
	public String loginForm() {
		return "loginForm";
	}
	
	@PostMapping("/login")
	public String login(
			@RequestParam("username")String username,
			@RequestParam("userword")String userword,
			MemberDto dto,
			HttpSession session) {
		
		// 이 방식이 아니라면?
		// MemberRepository에서 MemberEntity findByUsernameAndUserword(String username, String password) 를 정의해서 사용함
		
		Optional<MemberEntity> op = memberRepository.findById(username);
		
//		System.out.println("-------------------------------------------------------------");
//		System.out.println(op);
//		System.out.println(op.get().getUsername());
//		System.out.println(op.get().getUserword());
//		System.out.println("-------------------------------------------------------------\n\n");
		if(op.isEmpty()) {
			return "redirect:/loginForm?fail=1";
		}
		if(op.get().getUsername() != null) {
			if(op.get().getUserword().equals(userword)) {
				session.setAttribute("username", username);
				session.setAttribute("userword", userword);
				return "success";
			}else {
				return "redirect:/loginForm?fail=1";
			}
		}
		return "redirect:/loginForm?fail=1";
	}
}
