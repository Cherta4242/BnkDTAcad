package com.example.auth;

import com.example.domain.Member;


public class MemberDetails {

    private Member member;

    // 생성자
    public MemberDetails(Member member) {
        this.member = member;
    }

    // 아이디
    public String getUsername() {
        return member.getUsername();
    }

    // 비밀번호
    public String getPassword() {
        return member.getPassword();
    }

    // 이름
    public String getName() {
        return member.getName();
    }

    // 권한
    public String getRole() {
        return member.getRole();
    }
}