package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Long>{

	List<BoardEntity> findAllByOrderByBnoAsc();
}
