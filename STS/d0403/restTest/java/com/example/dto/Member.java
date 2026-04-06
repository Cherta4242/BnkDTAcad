package com.example.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Member {
	
	// 그래보이진 않겠지만 놀랍게도 email로 PK처럼 사용하려구요.
	private String email;
	private String name;
	
	
    public Member(String name, String email) {
    	this.email = email;
    	this.name = name;
    }
	
}
