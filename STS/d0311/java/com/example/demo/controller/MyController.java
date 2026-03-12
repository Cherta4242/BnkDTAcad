package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.DemoApplication;
import com.example.demo.dto.Member;
import com.example.demo.dto.Member2;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController {

    @SuppressWarnings("unused")
	private final DemoApplication demoApplication;

    MyController(DemoApplication demoApplication) {
        this.demoApplication = demoApplication;
    }
	@RequestMapping("/")	// localhost:8083/
	public String root() {
		System.out.println("index.jsp 실행합니다!");
		return "index";
	}
	
	@RequestMapping("/a")	// localhost:8083/a
	public String a() {
		System.out.println("A.jsp 실행합니다!");
		return "a";
	}
	
	@RequestMapping("/b")	// localhost:8083/b?x=1
	public String pageB(HttpServletRequest request) {
		System.out.println("B.................");
		String x = request.getParameter("x");
		System.out.println("X: " + x);
		return "b";	// webapp/WEB-INF/views/b.jsp
	}
	

	@RequestMapping("/c")	// http://localhost:8083/c?x=1
	public String pageC(@RequestParam("x") int x) {
		System.out.println("c.................");
		System.out.println("X: " + x);
		return "c";	// webapp/WEB-INF/views/c.jsp
	}
	
	@RequestMapping("/reg")
	public @ResponseBody Member reg(@RequestParam("no") int no, @RequestParam("name") String name, @RequestParam("phone") String phone) {
		System.out.println("Member에 파라미터 저장하기!");
		Member mb = new Member();
		mb.setNo(no);
		mb.setName(name);
		mb.setPhone(phone);
		System.out.println(mb.toString());
		return mb;
	}
	
	@RequestMapping("/reg1")
	public String reg2(Member member, Model model) {
		System.out.println("reg......." + member);
		model.addAttribute("name", member.getName());
		return "c";
	}
	
	// 8083/test/hong/홍길동	-> 쿼리스트링 형식이 아닌 패th 방식으로 데이터를 받기.
	@RequestMapping("/test/{id}/{name}")
	public String test(@PathVariable("id")String id,  @PathVariable("name") String name) {
		String idName = "url에 작성한 id: " + id + ", url에 작성한 name: " + name;
		System.out.println(idName);
		return idName;
	}

	
	
	
	// Member.jsp에서 사용하는 컨트롤러들.
	
	static ArrayList<Member2> al = new ArrayList<Member2>();
	
	@RequestMapping("/member")
	public String members() {
		System.out.println("MEMBER페이지 접속!");
		return "member";
	}
	
	@RequestMapping("/checking")
	@ResponseBody
	public String checking(@RequestParam("id")String id) {
		System.out.println("중복확인 버튼 누름!");
		for(int i = 0; i < al.size(); i++) {
			if(al.get(i).getId().equals(id)) {
				return "fail";
			}
		}
		return "sucess";
	}
	
	@RequestMapping("/insertMb")
	@ResponseBody
	public String insertMb(@RequestParam("id")String id, @RequestParam("pw")String pw, @RequestParam("name")String name) {
		
		Member2 mb = new Member2();
		mb.setId(id);
		mb.setPw(pw);
		mb.setName(name);
		System.out.println(mb.toString());
		al.add(mb);
		return "success";
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public String login(@RequestParam("id")String id, @RequestParam("pw")String pw) {
		System.out.println("로그인버튼 누름!");
		for(int i = 0; i < al.size(); i++) {
			if(al.get(i).getId().equals(id) && al.get(i).getPw().equals(pw)) {
				return "" + al.get(i).getName() + "님 환영합니다.";
			}
		}
		return "fail";
	}
}
