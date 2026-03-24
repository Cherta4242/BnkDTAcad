package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.MemberEntity;

public interface MemberRepository extends JpaRepository <MemberEntity, Long>{

	public MemberEntity findByIdAndPassword(String username, String password);
}
