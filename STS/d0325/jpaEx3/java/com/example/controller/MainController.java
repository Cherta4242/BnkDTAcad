package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.UserEntity;
import com.example.repository.UserRepository;

@Controller
public class MainController {
	@Autowired
	UserRepository userRepository;
	
	
	
	
	@GetMapping("/")
	public String root(Model model) {
		List<UserEntity> list = userRepository.findAll();
		model.addAttribute("list", list);
		return "index";
	}
	
	
	@GetMapping("/testPage")
	public String Test() {
		return "test";
	}
	
	@PostMapping("/test")
	public String result(@RequestParam("id")Long id,
			@RequestParam("name")String name,
			Model model) {

		List<UserEntity> ent = userRepository.findByIdOrName(id, name);
		System.out.println("------------------------------------\n" + ent
				+ "\n--------------------------------------------------");
		model.addAttribute("ent", ent);
		return "result";
	}
	
	
}
