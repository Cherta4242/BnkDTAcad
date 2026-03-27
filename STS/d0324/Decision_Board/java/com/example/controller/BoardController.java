package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entity.BoardEntity;
import com.example.entity.MemberEntity;
import com.example.repository.BoardRepository;
import com.example.repository.MemberRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {

	@Autowired
	BoardRepository boardRepository;
	
	@Autowired
	MemberRepository memberRepository;
	
	
	@GetMapping("/goBoard")
	public String goBoard(Model model) {
		
		List<BoardEntity> boardList = boardRepository.findAllByOrderByBnoAsc();
		
		
		System.out.println("-----------------------");
		System.out.println(boardList);
		
		model.addAttribute("boardList", boardList);
		
		
		return "boardP/board";
	}
	
	@PostMapping("/boardWrite")
	public String boardWrite(BoardEntity boardEntity, HttpSession session) {
		
		Long mno = (Long) session.getAttribute("userMno");
		
		MemberEntity member = memberRepository.findById(mno).get();
		System.out.println("-------------------------------------------");
		System.out.println();
		System.out.println();
		System.out.println(mno);
		System.out.println(member);
		
		
		boardEntity.setMember(member);
		
		boardRepository.save(boardEntity);
		
		return "redirect:/goBoard";
	}
	
	@GetMapping("/boardP/goboardDetail/{id}")
	public String boardDetail(@PathVariable("id")Long bno, Model model) {
		
		System.out.println("id:" + bno);
		
		Optional<BoardEntity> board = boardRepository.findById(bno);
		model.addAttribute("btitle", board.get().getBtitle());
		model.addAttribute("nickname", board.get().getMember().getNickname());
		model.addAttribute("bcontent", board.get().getBcontent());
		model.addAttribute("usermodelId", board.get().getMember().getId());
		
		return "boardP/boardDetail";
	}
}
