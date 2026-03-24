package com.example.dto;

import com.example.entity.MemberEntity;

import lombok.Data;

@Data
public class MemoDto {
	
	private String message;
	private MemberEntity writer;
}
