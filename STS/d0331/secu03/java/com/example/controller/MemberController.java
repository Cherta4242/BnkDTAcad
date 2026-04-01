package com.example.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.auth.CustomUserDetails;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/members")
public class MemberController {

	@GetMapping("/welcome")
	public String welcome(
			Model model,
			Principal principal,
			@AuthenticationPrincipal CustomUserDetails customUserDetails
			) {
		log.info("welcome.................");
		
		Authentication authentication = SecurityContextHolder
											.getContext()
											.getAuthentication();
		CustomUserDetails userDetails
							= (CustomUserDetails)authentication.getPrincipal();
		model.addAttribute("username", userDetails.getUsername());
		model.addAttribute("name", userDetails.getName());
		model.addAttribute("role", userDetails.getRole());
		
//		principal  객체 주입
		model.addAttribute("username2", principal.getName());
		model.addAttribute("principal", principal.toString());
		
//		@AuthenticationPrincipal 사용
		model.addAttribute("username3", customUserDetails.getUsername());
		model.addAttribute("name3", customUserDetails.getName());
		model.addAttribute("role3", customUserDetails.getRole());
		
		return "/members/welcome";
	}

	
}
