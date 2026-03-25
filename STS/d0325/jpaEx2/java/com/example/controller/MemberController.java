package com.example.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.MemberEntity;
import com.example.repository.MemberRepository;

import jakarta.servlet.http.HttpSession;

public class MemberController {

	MemberRepository memberRepository;
	
	@PostMapping("/login")
	   public String login(@RequestParam("username")String username,
	                  @RequestParam("password")String password,
	                  HttpSession session) {
	      
	      MemberEntity member = memberRepository.findByUsernameAndUserword(username, password);
	      System.out.println("login: " + member);
	      
	      if(member == null) {
	         return "redirect:/loginForm";
	      }
	      
	      session.setAttribute("username", member.getUsername());
	      
	      String redirectURL = (String)session.getAttribute("redirectURL");
	      System.out.println("C_redirectURL: " + redirectURL );
	      
	      if(redirectURL != null && !redirectURL.isBlank()) {
	         return "redirect:" + redirectURL;
	      }
	      
	      return "success";
	   }
}
