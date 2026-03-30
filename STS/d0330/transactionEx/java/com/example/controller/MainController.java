package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.service.BuyAndLogService;
import com.example.service.IBuyTicketService;

@Controller
public class MainController {

	@Autowired
	IBuyTicketService buyTicket;
	
	@Autowired
	BuyAndLogService buyTicketLog;
	
	@RequestMapping("/")
	public @ResponseBody String root() {
		return "Transaction Ex";
	}
	
	@RequestMapping("/buy_ticket")
	public String buy_ticket() {
		return "buy_ticket";
	}
	
	
	@RequestMapping("/buy_ticket_card")
	public String buy_ticket_card(
			@RequestParam("consumerid")String consumerid,
			@RequestParam("amount")String amount,
			@RequestParam("error")String error,
			Model model) {
		
//		int result = buyTicket.buy(consumerid, Integer.parseInt(amount), error);
		int result = buyTicketLog.buy(consumerid, Integer.parseInt(amount), error);
		
		model.addAttribute("consumerid", consumerid);
		model.addAttribute("amount", amount);
		
		if(result == 1) {
			return "buy_ticket_end";
		}else {
			return "buy_ticket_error";			
		}
	}
}
