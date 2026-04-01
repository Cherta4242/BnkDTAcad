package com.example.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.MemberDao;
import com.example.domain.Member;

@Service
public class MemberDetailsService {

	@Autowired
	private MemberDao memberDao;
	

	public MemberDetails loadMemberByUsername(String username) {

	    Member member = memberDao.findByUsername(username);

	    if (member == null) {
	        return null;
	    }

	    return new MemberDetails(member);
	}
	
}
