package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.Transaction1;
import com.example.repository.TransactionJpa1_Repository;
import com.example.repository.TransactionJpa2_Repository;

import jakarta.transaction.Transactional;

@Controller
public class MainController {

	@Autowired
	TransactionJpa1_Repository tjRepository1;
	@Autowired
	TransactionJpa2_Repository tjRepository2;
	
	
	@RequestMapping("/")
	public @ResponseBody String root() {
		return "Transaction Ex with Jpa!";
	}
	
	@RequestMapping("/buy_ticket")
	public String buy_ticket() {
		return "buy_ticket";
	}
	
	@RequestMapping("/buy_ticket_card")
	@Transactional
	public String buy_ticket_card(
			Transaction1 tEntity1,
			@RequestParam("error")String error,
			Model model) {
		System.out.println(tEntity1.getConsumerid());
		System.out.println(tEntity1.getAmount());
		

		tjRepository1.save(tEntity1);
		
		if(error.equals("1")) {
			int n = 10 / 0;
			System.out.println(n);
		}
		
		tjRepository2.save(tEntity1);
		model.addAttribute("consumerid", tEntity1.getConsumerid());
		model.addAttribute("amount", tEntity1.getAmount());
		return "buy_ticket_end";

		
	}
	
}
