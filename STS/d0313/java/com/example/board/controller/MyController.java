package com.example.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.board.dao.BoardDAO;
import com.example.board.dto.BboardDTO;
import com.example.board.dto.BoardDTO;

import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {

	// 페이지 정의
	// ------------------------------------------------------------
	@RequestMapping("/")
	public String root() {
		System.out.println("indexPage 접속");
		System.out.println("-------------");
		System.out.println();
		
		return "index";
	}
	@RequestMapping("/lgpage")
	public String loginPage() {
		System.out.println("loginPage 접속");
		System.out.println("-------------");
		System.out.println();
		
		return "login";
	}
	@RequestMapping("/sgupage")
	public String signupPage() {
		System.out.println("signupPage 접속");
		System.out.println("--------------");
		System.out.println();
		
		return "signup";
	}
	@RequestMapping("/mypage")
	public String myPage() {
		System.out.println("MyPage 접속");
		System.out.println("------------");
		System.out.println();
		
		return "mypage";
	}
	@RequestMapping("/pleaseTT")
	public String please() {
		System.out.println("돈좀요 ㅜ");
		
		return "please";
	}
	
	// 기능 정의
	// ------------------------------------------------------------
	@Autowired
	private BoardDAO dao;
	
	
	// 회원가입
	@RequestMapping("/signup")
	public String signup(BoardDTO dto, Model model) {
		System.out.println("회원가입 시도!");
		System.out.println("-----------");
		
		System.out.println(dto.getJbid());
		System.out.println(dto.getJbpw());
		System.out.println(dto.getJbname());
		
		int result = dao.insert(dto);
		if(result == 0) {
			System.out.println("회원가입 실패! 다시 시도해주세요!");
			model.addAttribute("signupmsg", "no");
			return "singup";
		}
		model.addAttribute("signupmsg", "ok");
		System.out.println("회원가입 성공! 로그인 페이지로 이동하겠습니다~");
		return "signup";	
	}
	
	// 로그인
	@RequestMapping("/login")
	public String login(BoardDTO dto, Model model, HttpSession session) {
		System.out.println("로그인 시도!");
		System.out.println("---------");
		
		BoardDTO result = dao.check(dto);
		if(result == null) {
			System.out.println("null값임.");
			model.addAttribute("loginmsg", "no");
			return "login";
		}
		
		session.setAttribute("jbid", result.getJbid());
		session.setAttribute("jbpw", result.getJbpw());
		session.setAttribute("jbname", result.getJbname());
		System.out.println("로그인 성공");
		model.addAttribute("loginmsg", "ok");
		
		return "login";
	}
	
	// 로그아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		System.out.println("로그아웃 함");
		System.out.println("---------");
		System.out.println();
		
		session.invalidate();
		return "redirect:/";
	}
	
	// 목록 조회 (이동과 데이터 처리를 같이 함)
	@RequestMapping("/show")
	public String show(Model model) {
		List<BboardDTO> list = dao.showBoard();
		
		model.addAttribute("list", list);
		
		for(BboardDTO b : list) {
		    System.out.println(b.getJbbno());
		    System.out.println(b.getJbbtitle());
		    System.out.println(b.getJbname());
		}
		
		return "show";
	}
	
	// 상세보기
	@RequestMapping("/view")
	public String view(@RequestParam("jbbno")int jbbno, Model model) {
	    System.out.println("view Page 접속!");
		System.out.println("목록 번호: " + jbbno + "받음!");
	    
		BboardDTO dto = dao.viewBoard(jbbno);
		model.addAttribute("dto", dto);
	    
	    return "view";
	}
	
}
