package com.example.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.JpaBoard;
import com.example.repository.JpaBRe;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class Maincontroller {
	
	private final JpaBRe jpabr;
	
	@GetMapping("/")
	public String root(Model model) {
		List<JpaBoard> jpaEnt = jpabr.findAll();
		System.out.println(jpaEnt);
		
		model.addAttribute("boardList", jpaEnt);
		
		return "index";
	}
	
	@GetMapping("/detail")
	public String goDetailPage(
			@RequestParam("bno")Long bno, Model model) {
		
		JpaBoard jpaEnt = jpabr.findById(bno).orElse(null);
		model.addAttribute("jpaEnt", jpaEnt);
		
		return "detail";
	}
	
	@GetMapping("/writeForm")
	public String geWriting() {
		
		return "write";
	}
	
	@PostMapping("/write")
	public String write(JpaBoard jpaEnt) {
		JpaBoard jEnt = jpabr.save(jpaEnt);
		System.out.println(jEnt);
		
		return "redirect:/";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("bno")Long bno) {
		jpabr.deleteById(bno);
		
		return "redirect:/";
	}
}