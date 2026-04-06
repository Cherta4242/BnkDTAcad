package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dto.Member;

@Service
public class MemberService {

    private List<Member> members = new ArrayList<>();

    public MemberService() {
        members.add(new Member("kim", "a@gmail.com"));
        members.add(new Member("chi", "b@gmail.com"));
        members.add(new Member("mat", "c@gmail.com"));
        members.add(new Member("it", "d@gmail.com"));
        members.add(new Member("da", "e@gmail.com"));
    }

    // 전체 출력
    public List<Member> getMembers() {
        return members;
    }

    
    //이메일 검색으로 출력
    public Member getMemberByEmail(String email) {
    	// 이메일로 향상된 for문 돌리고
        for (Member m : members) {
        	// 만약 email이 원하는거 찾는다면?
            if (m.getEmail().equals(email)) {
                return m; // 데이터? 반환
            }
        }

        return null; // 못 찾으면 null
    }

    // 멤버 추가
    public Member addMember(Member member) {
        members.add(member);
        return member;
    }

    
    //이ㅂ메일로 멤버 찾아서 수정
    public Member updateMember(String email, Member updated) {
    	
    	// 멤버 안에 쭉 돌려보고
        for (Member m : members) {
        	// 이메일 있으면?
            if (m.getEmail().equals(email)) {
                m.setName(updated.getName()); // 원하는 이름으로 수정
                return m;
            }
        }
        // 이메일 못찾으면 끝
        return null;
    }

    
    // 삭제 됐냐 안됐냐?
    public boolean deleteMember(String email) {
    	
    	// 반복문으로 계속 돌려보고 
        for (int i = 0; i < members.size(); i++) {
        	// 찾았으면?
            if (members.get(i).getEmail().equals(email)) {
                members.remove(i); // 삭제
                return true;
            }
        }
        // 못찾으면 없어요~ 하기
        return false;
    }
}