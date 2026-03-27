package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entity.MemberEntity;
import com.example.repository.MemberRepository;

@Controller
public class RegistController {
	
	@Autowired
	MemberRepository mbRps;
	
	@GetMapping("/regForm")
	public String RegistPage() {
		return "register";
	}
	
	@PostMapping("/regist")
	public String regist(MemberEntity member) {
		
		
//		System.out.println("------------------------------");
//		System.out.println(member.getId());
//		List<MemberEntity> list = mbRps.findAll();
//		System.out.println(list);
//		System.out.println("------------------------------");
		
		
		if(mbRps.findById(member.getId()) == null) {
			mbRps.save(member);
			return "redirect:/loginForm";			
		}
		
		return "redirect:/regForm";
	}
	
}
