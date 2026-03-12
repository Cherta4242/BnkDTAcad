package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.MyUserDao;
import com.example.demo.dto.MyUserDto;

@Controller
public class MyController {
	
    
    
    // 페이지 이동
	// -------------------------------------------------------------------------
	@RequestMapping("/")
	public String root() {
		System.out.println("index.jsp 실행합니다!");
		
		return "index";
	}
	@RequestMapping("/signup")
	public String signupPage() {
		System.out.println("signup.jsp 실행합니다!");
		
		return "signup";
	}
	@RequestMapping("/login")
	public String loginPage() {
		System.out.println("login.jsp 실행합니다!");
		
		return "login";
	}
	
	
	// 기능 정의
	// -------------------------------------------------------------------------
	private MyUserDao dao;
	
	@GetMapping("/list")
	public String list(Model model) {
		System.out.println("list..");
		
		List<MyUserDto> list = dao.list();
		model.addAttribute("list", list);
		return "list";
	}
	
	@RequestMapping("/signup")
	public String singup(@RequestParam("id")String id, @RequestParam("pw")String pw, @RequestParam("name")String name) {
		System.out.println("회원가입 할게요");
		System.out.println("입력 아이디: " + id);
		System.out.println("입력 비밀번호: " + pw);
		System.out.println("입력 이름: " + name);
		dao.insertUser(id, pw, name);
		return "signup";
	}
}
