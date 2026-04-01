package com.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.domain.Member;

@Mapper
public interface MemberDao{

	public int regist(@Param("member")Member member);
	public Member findByUsername(@Param("username")String username);
	public Member findByUsernameAndPassword(@Param("username")String username, @Param("password")String password);
	
}
