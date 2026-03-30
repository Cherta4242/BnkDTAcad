package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="transactionJpa2")
@Data
public class Transaction2 {

	@Id
	private String consumerid;
	private int amount;
}
