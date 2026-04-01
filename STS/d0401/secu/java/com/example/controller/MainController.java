package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dto.MemberDto;
import com.example.entity.Member;
import com.example.service.MemberService;

@Controller
public class MainController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/")
	public String root() {
		return "index";
	}
	
	
	@GetMapping("/regist")
	public String registFrom() {
		return "regist";
	}
	
	@PostMapping("/registProc")
	@ResponseBody
	public String registprco(MemberDto memberDto) {
		Member member = memberService.regist(memberDto);
		return member.getUsername();
	}
	
	
	@GetMapping("/login")
	public String loginFrom() {
		return "login";
	}
	
	// 로그인 실패
	@GetMapping(value="/login", params = "error")
	public String loginError(Model model) {
		model.addAttribute("errorMsg", "아이디 또는 비밀번호가 틀렸습니다.");
		
		return "login";
	}
	
	//로그아웃 후
	@GetMapping(value="/login", params = "logout")
	public String loginLogout(Model model) {
		model.addAttribute("logoutMsg", "로그아웃 되었습니다.");
		
		return "login";
	}
	
	@GetMapping("/success")
	public String success() {
		return "success";
	}
	
	@PreAuthorize("hasRole('AMDIN')")
	@GetMapping("/admin")
	public String admin() {
		return"admin";
	}
	
	@PreAuthorize("hasAnyRole('ADMIN', 'MEMBER')")
	@GetMapping("/member")
	public String member() {
		return "member";
	}
	
}
