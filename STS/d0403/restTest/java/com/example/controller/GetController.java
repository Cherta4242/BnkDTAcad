package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.Member;
import com.example.service.MemberService;



//																		http://192.168.0.184:8080/api/v1/members
@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/api/v1")
public class GetController {

	// 디비 쓰기 싫어서 서비스로 만들어버렸습니다.
    private final MemberService memberService;

    
    public GetController(MemberService memberService) {
        this.memberService = memberService;
    }

    
    @GetMapping("/members")
    public List<Member> getMembers() {
        return memberService.getMembers();
    }

    @GetMapping("/members/{email}")
    public Member getMember(@PathVariable String email) {
        return memberService.getMemberByEmail(email);
    }
}
