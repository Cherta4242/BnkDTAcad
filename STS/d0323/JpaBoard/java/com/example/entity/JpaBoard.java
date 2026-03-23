package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Jpa_Board")
@Data
public class JpaBoard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bno;
	@Column(nullable = false, length = 20)
	private String writer;
	@Column(nullable = false, length = 100)
	private String title;
	@Column(nullable = true, length = 500)
	private String content;
}
