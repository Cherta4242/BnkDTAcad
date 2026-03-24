package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dto.MemoDto;
import com.example.entity.MemoEntity;
import com.example.repository.MemoRepository;

@Controller
public class MemoController {
	
	@Autowired
	private MemoRepository memoRepository;
	
	@GetMapping("/memoList")
	public String memoList(Model model) {
		List<MemoEntity> memoList = memoRepository.findAll();
		
		model.addAttribute("memoList", memoList);
		System.out.println("---------------------------------------");
		return "memoList";
	}
	
	@GetMapping("/memoRegForm")
	public String gomemoRegForm() {
		return "memoRegForm";
	}
	
	@PostMapping("/memoRegist")
	public String memoRegist(MemoDto dto, MemoEntity memo) {
		System.out.println("---------------------------------------");
		System.out.println("message: " + dto.getMessage());
		System.out.println("member: " + dto.getWriter());
		memo.setMember(dto.getWriter());
		
		memoRepository.save(memo);
		System.out.println(memo.getMember().getClass());
		return "redirect:/memoList";
	}
}
