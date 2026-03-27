package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	
	// index 페이지 접속
	@GetMapping("/")
	public String root() {
		return "index";
	}

	// board 작성 페이지로 이동
	@GetMapping("/goboardWrite")
	public String goBoardWrite() {
		return "boardP/boardWrite";
	}
	
	@GetMapping("/goOtherDec")
	public String goOtherDecision() {
		return "OtherDec";
	}
	
	@GetMapping("/gomyDecision")
	public String goMyDecision() {
		return "myDecision";
	}
	
	@GetMapping("/gomyPage")
	public String goMyPage() {
		return "myPage";
	}
}
