package com.example.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.entity.Member;

public class CustomUserDetails implements UserDetails{

	private Member member;
	
	public CustomUserDetails(Member member) {
		this.member = member;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Collection<GrantedAuthority> collection = new ArrayList<>();
		collection.add(new GrantedAuthority() {

			@Override
			public @Nullable String getAuthority() {
				return member.getRole();
			}
			
		});
		
		return collection;
	}

	@Override
	public @Nullable String getPassword() {
		return member.getPassword();
	}

	@Override
	public String getUsername() {
		return member.getUsername();
	}
	
	public String getName() {
		return member.getName();
	}
	
	public String getRole() {
		return member.getRole();
	}
	
	public String getEmail() {
		return member.getEmail();
	}
	
}
