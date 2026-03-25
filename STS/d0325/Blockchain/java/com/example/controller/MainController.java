package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.blockchain.Blockchain;
import com.example.dto.BCMemberDto;
import com.example.entity.BCMemberEntity;
import com.example.repository.BCMemberRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

	@Autowired
	BCMemberRepository bcmemberRepository;
	
	@GetMapping("/")
	public String root() {
		return "index";
	}
	
	@GetMapping("/regForm")
	public String goRegPage() {
		return "regist";
	}
	
	@PostMapping("/regist")
	public String regist(BCMemberDto dto, BCMemberEntity bcm) {
		
		System.out.println(dto);
		System.out.println(bcm);
		
		dto.setPw(Blockchain.blcPassword(dto.getPw()));
		
		System.out.println(dto);
		
		bcm.setPw(dto.getPw());

		System.out.println(bcm);
		
		bcmemberRepository.save(bcm);
		
		return "redirect:/";
	}
	
	@GetMapping("/loginForm")
	public String loginPage() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("id")String id,
			@RequestParam("pw")String pw,
			HttpSession session) {
		System.out.println("-------------------------------------------");
		BCMemberEntity bcmemberentity = bcmemberRepository.findByIdAndPw(id, pw);
		session.setAttribute("user", bcmemberentity);
		
		
		
		
		return "redirect:/";
	}
	
	
	@GetMapping("searchId")
	public String searchPage() {
		return "search";
	}
	
	@PostMapping("search")
	public String search() {
		
		
		
		return "redirect:/searchId";
	}
	
}
