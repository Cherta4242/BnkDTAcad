package com.example.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.MemberEntity;
import com.example.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MyController {

	private final MemberRepository memberRepository;
	
	@GetMapping("/")
	public String root() {
		return "index";
	}
	
	@GetMapping("registForm")
	public String registForm() {
		return "registForm";
	}
	
	@PostMapping("/regist")
	public String regist(MemberEntity member) {
		System.out.println(member);
		
		MemberEntity M = memberRepository.save(member);
		System.out.println(M);
		return "redirect:/";
	}
	
	@GetMapping("/member")
	public String getmember(@RequestParam("id")String id, Model model) {
		System.out.println(id);
		MemberEntity member = memberRepository.findById(id);
		model.addAttribute("member", member);
		
		return "member";
	}
	
//	@GetMapping("/searchMember")
//	public String searchMember(@RequestParam("word")String id, Model model) {
//		System.out.println(id);
//		List<MemberEntity> list = memberRepository.list(id);
//		model.addAttribute("list", list);
//		
//		return "member";
//		
//	}
//	
	@GetMapping("/members")
	public String getMembers(Model model) {
		List<MemberEntity> members = memberRepository.findAll();
		System.out.println(members);
		model.addAttribute("members", members);
		model.addAttribute("length", members.size());
		return "members";
	}
	
	@GetMapping("/deleteForm")
	public String deletemember() {
		return "delete";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("mno")Long mno) {
		memberRepository.deleteById(mno);
		return "redirect:/members";
	}
	
	@GetMapping("/updateForm")
	public String goUpdate(@RequestParam("id")String id, Model model) {
		MemberEntity member = memberRepository.findById(id);
		model.addAttribute("member", member);
		return "update";
	}
	
	@PostMapping("/update")
	public String update(	@RequestParam("pw")String pw,
							@RequestParam("name")String name,
							Model model) {
		MemberEntity member = null;
		member.setPw(pw);
		member.setName(name);
		
		memberRepository.save(member);
		
		return "redirect:/members";
	}
}
