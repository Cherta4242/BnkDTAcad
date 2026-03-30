package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import com.example.dao.ITransaction3Dao;

import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class LogWriteService {
	
	@Autowired
	ITransaction3Dao transaction3;
	
	public int write(String consumerid, int amount) {
		try {
			transaction3.pay(consumerid, amount);
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
			
//			return 0;
			throw new RuntimeException();
		}
	}
	
	
}
