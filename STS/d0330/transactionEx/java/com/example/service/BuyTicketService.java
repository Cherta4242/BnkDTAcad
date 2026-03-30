package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.ITransaction1Dao;
import com.example.dao.ITransaction2Dao;



@Service
public class BuyTicketService implements IBuyTicketService{

	@Autowired
	ITransaction1Dao transaction1;
	
	@Autowired
	ITransaction2Dao transaction2;
	
	@Override
	@Transactional
	public int buy(String consumerid, int amount, String error) {
		
		try {
			transaction1.pay(consumerid, amount);
	
			// 에러 발생시키기
			if(error.equals("1")) {
				int n = 10 / 0;
				System.out.println(n);
			}
			
			
			transaction2.pay(consumerid, amount);
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
//			return 0;
		}
		
	}



}
