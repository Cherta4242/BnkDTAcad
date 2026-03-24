package com.example.dto;

import com.example.entity.MemberEntity;

import lombok.Data;

@Data
public class MemberDto {

	private MemberEntity id;
	private String password;
}
