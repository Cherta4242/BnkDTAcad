package com.example.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.Member;
import com.example.service.MemberService;

@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/api/v1")
public class PostController {
	
	// 디비 쓰기 싫어서 서비스로 만들어버렸습니다.
    private final MemberService memberService;

    public PostController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/members")
    public Member postMember(@RequestBody Member member) {

        System.out.println(member.getName());
        System.out.println(member.getEmail());

        return memberService.addMember(member);
    }
}