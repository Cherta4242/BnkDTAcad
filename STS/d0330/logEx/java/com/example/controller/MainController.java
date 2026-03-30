package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {

	@GetMapping("/")
	public String root() {
		System.out.println("root.............");
		log.trace("TRACE log가 출력됩니다.");
		log.debug("DEBUG log가 출력됩니다.");
		log.info("log가 출력됩니다.");			// 정상 실행
		log.warn("WARN log가 출력됩니다.");		// 문제 가능성
		log.error("ERROR log가 출력됩니다.");	// 오류 발생
		return "index";
	}
	
	@GetMapping("/ex01")
	public String ex01(@RequestParam("username")String username,
			Model model) {
		log.info("username: {}",  username);
		model.addAttribute("username", username);
		
		return "ex01";
	}
	
}
