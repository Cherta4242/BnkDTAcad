package com.example.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.MemberService;

@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/api/v1")
public class DeleteController {
	
	// 디비 쓰기 싫어서 서비스로 만들어버렸습니다.
    private final MemberService memberService;

    
    public DeleteController(MemberService memberService) {
        this.memberService = memberService;
    }

    
    @DeleteMapping("/members/{email}")
    public String deleteMember(@PathVariable("email") String email) {

        boolean deleted = memberService.deleteMember(email);

        if (deleted) {
            return email + " 삭제 완료";
        } else {
            return "해당 유저 없음";
        }
    }
}