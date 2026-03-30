package com.example.service;

import org.springframework.stereotype.Service;

@Service
public interface IBuyTicketService{
	public int buy(String consumerid, int amount, String error);
}
