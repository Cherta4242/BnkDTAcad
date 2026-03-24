package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.MemoEntity;


public interface MemoRepository extends JpaRepository<MemoEntity, Long>{

}
