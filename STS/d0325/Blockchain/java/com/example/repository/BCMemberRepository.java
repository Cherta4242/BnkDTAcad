package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.BCMemberEntity;

public interface BCMemberRepository extends JpaRepository<BCMemberEntity, String>{

	public BCMemberEntity findByIdAndPw(String id, String pw);
}
