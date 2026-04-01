package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="my_member")
@Getter
@Setter
@ToString
public class Member {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(unique = true, nullable = false)
	private String username;
	
	private String password;
	private String role;
	private String name;
	@Column(unique = true)
	private String email;
}
