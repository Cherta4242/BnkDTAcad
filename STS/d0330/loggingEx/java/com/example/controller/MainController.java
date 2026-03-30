package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {
	int mainview = 0;
	int selectview = 0;
	
	int iceAme = 0;
	int cafeRt = 0;
	int moca = 0;
	int hubmint = 0;
	
	
	@GetMapping("/")
	public String root() {
		mainview++;
		log.info("메인화면 -> " + mainview + "번 접속!");
		return "index";
	}
	
	@GetMapping("/select")
	public String selectView() {
		try {
			selectview++;
			log.info("메뉴화면 -> " + selectview + "번 접속!");
			int n = 10/0;			
		} catch (Exception e) {
			log.error("에러입니다용!! {}");
		}
		
		return "select";
	}
	
	@RequestMapping("/selected")
	public String userSelect(@RequestParam("menu")String menu) {
		if(menu.equals("iceAme")) {
			iceAme++;
		}else if(menu.equals("cafeRt")) {
			cafeRt++;
		}else if(menu.equals("moca")) {
			moca++;
		}else if(menu.equals("hubmint")) {
			hubmint++;
		}else {
			System.out.println("뭐 잘못선택하신듯?");
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/view")
	public String goView(Model model) {
		
		model.addAttribute("mainview", mainview);
		model.addAttribute("selectview", selectview);
		model.addAttribute("iceAme", iceAme);
		model.addAttribute("cafeRt", cafeRt);
		model.addAttribute("moca", moca);
		model.addAttribute("hubmint", hubmint);
		
		return "view";
	}
}
