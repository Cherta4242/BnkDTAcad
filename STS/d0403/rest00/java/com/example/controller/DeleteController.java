package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/delete-api")
public class DeleteController {
	
	
	
	@DeleteMapping("/member/{email}/{email2}/{email3}")
	public String deleteMember(@PathVariable("email")String email,
			@PathVariable("email2")String email2,
			@PathVariable("email3")String email3) {
		
		List<String> list = new ArrayList<>();
		
		list.add(email);
		list.add(email2);
		list.add(email3);
		
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		
		return list.toString();
	}
	
}
