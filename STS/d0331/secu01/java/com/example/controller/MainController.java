package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.auth.AuthSession;
import com.example.auth.MemberDaoAuthProvider;
import com.example.auth.MemberDetails;
import com.example.auth.PasswordEncoder;
import com.example.dao.MemberDao;
import com.example.domain.Member;

@Controller
public class MainController {

	@Autowired
	MemberDaoAuthProvider mdap;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	MemberDao memberDao;
	@Autowired
	AuthSession session;
	
	
	
	// index Page
	@GetMapping("/")
	public String root() {
		return "index";
	}
	
	// regist Page
	// 1. 등록 폼 열기("/registForm")
	@GetMapping("/registForm")
	public String registForm() {
		return "registForm";
	}
	
	// 2. 등록 처리("/regist")
	@PostMapping("/regist")
	public String regist(Member member) {
		
		// 등록 시 패스워드 암호화 필수, role필드 값은 "ROLE_MEMBER"로 설정.
		member.setPassword(passwordEncoder.passwordEncoder(member.getPassword()));
		member.setRole("ROLE_MEMBER");
		// 등록
		int result = memberDao.regist(member);
		
		// 등록 성공 시 로그인 폼으로 이동
		if(result == 1) {
			return "redirect:/loginForm";
		}
		
		// 등록 실패 시 등록 폼으로 이동	
		return "redirect:/registForm";
	}
	
	// 3. 로그인 폼 열기("/loginFrom")
	@GetMapping("/loginForm")
	public String loginForm() {
		return "loginForm";
	}
	
	// 4. 로그인 처리("/login")
	@PostMapping("/login")
	public String login(
			@RequestParam("username")String username,
			@RequestParam("password")String password,
			Model model) {
		
		System.out.println("1차 확인!!-------------------------------------------------------------------------------------");
		// 로그인 성공 시 회원 전용 메인화면으로 이동
		if(mdap.loginCheck(username, password)) {
			System.out.println("2차 확인!!-------------------------------------------------------------------------------------");
			
			return "/member/main?username="+username;
		}
		// 실패 시 로그인 폼으로 이동 - 다시 로그인하라고 안내하기
		System.out.println("3차 확인!!-------------------------------------------------------------------------------------");
		return "redirect:/loginForm";
		
	}
	
	// 5. 회원 전용 메인페이지 열기("/member/main")
	// 세션에 저장된 회원 정보를 화면에 출력하기
	@GetMapping("/member/main")
	public String memberPage(@RequestParam("username")String username, Model model) {
		// 이렇게 짜긴 했는데 username을 어떻게 넣을까? 가 되는거.
		// 즉 usrname을 대입시키는 것이 완료되면 정보는 출력 가능. 
		// 어떻게 해결할까...
		
	    MemberDetails member = mdap.getMemberDetails(username);

	    System.out.println(member.getName());
	    model.addAttribute("member", member);
		
		return "member/main";
	}
	
	
	
}
