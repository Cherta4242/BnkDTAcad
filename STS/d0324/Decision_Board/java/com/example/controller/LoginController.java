package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.MemberEntity;
import com.example.repository.MemberRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	@Autowired
	MemberRepository memberRepository;
	
	@GetMapping("/loginForm")
	public String loginPage() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(
			@RequestParam("id")String id,
			@RequestParam("password")String password,
			HttpSession session) {
		
		System.out.println("--------------------------------");
		System.out.println(id + password);
		MemberEntity member = memberRepository.findByIdAndPassword(id, password);
		if(member != null) {
			session.setAttribute("userId", member.getId());
			session.setAttribute("userPassword", member.getPassword());
			session.setAttribute("userNickname", member.getNickname());			
		}else {
			return "redirect:/loginForm";
		}
		
		
		return "redirect:/";
	}
	
}
