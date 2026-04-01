package com.example.dto;

import lombok.Data;

@Data
public class MemberDto {

	private Long id;
	private String username;
	private String password;
	private String role;
	private String name;
	private String email;
}
