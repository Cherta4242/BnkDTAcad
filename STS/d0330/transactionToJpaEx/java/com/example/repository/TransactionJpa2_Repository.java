package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Transaction1;
import com.example.entity.Transaction2;

public interface TransactionJpa2_Repository extends JpaRepository<Transaction2, String>{

	void save(Transaction1 tEntity);


}
