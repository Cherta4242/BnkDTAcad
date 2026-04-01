package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dto.MemberDto;
import com.example.entity.Member;
import com.example.service.JoinService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {

	@Autowired
	private JoinService joinService;
	
	@GetMapping("/")
	public String root() {
		log.info("root/....................");
		return "index";
	}
	
	@GetMapping("/regist")
	public String regist() {
		log.info("regist........form.......");
		return "registForm";
	}
	
	@PostMapping("/registProc")
	public String registproc(MemberDto memberDto) {
		Member member = joinService.regist(memberDto);
		if(member == null) {
			return "redirect:/regist";
		}
		
		log.info("회원 등록 성공...................");
		
		
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String loginFrom() {
		log.info("loginForm...........................");
		
		return "loginFrom";
	}
	
	
}
