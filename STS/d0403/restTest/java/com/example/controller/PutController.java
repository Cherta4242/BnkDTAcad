package com.example.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.Member;
import com.example.service.MemberService;

@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/api/v1")
public class PutController {

	
	// 디비 쓰기 싫어서 서비스로 만들어버렸습니다.
    private final MemberService memberService;

    public PutController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PutMapping("/members/{email}")
    public Member putMember(
            @PathVariable String email,
            @RequestBody Member member) {

        System.out.println("수정 대상: " + email);
        System.out.println("변경 이름: " + member.getName());

        return memberService.updateMember(email, member);
    }
}