package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.MemberEntity;

public interface MemberRepository extends JpaRepository <MemberEntity, Long>{
	
	public MemberEntity findById(String id);
	
	public MemberEntity findByIdAndPassword(String id, String password);
}
