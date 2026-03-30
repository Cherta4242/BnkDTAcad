package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BuyAndLogService {

    private final IBuyTicketService IBuyTicketService;

	@Autowired
	BuyTicketService buyTicket;
	
	@Autowired
	LogWriteService logWrite;

    BuyAndLogService(IBuyTicketService IBuyTicketService) {
        this.IBuyTicketService = IBuyTicketService;
    }
	
	public int buy(String consumerid, int amount, String error) {
		try {
			buyTicket.buy(consumerid, amount, error);
			
			if(error.equals("2")) {
				int n = 10 / 0;
				System.out.println();
			}
			
			logWrite.write(consumerid, amount);
			return 1;
			
		}catch(Exception e) {
			System.out.println("[Transaction Propagation #1] Rollback");
			return 0;
		}
	}
	
}
