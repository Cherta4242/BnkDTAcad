package com.example.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginCheckInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception{
		
		System.out.println(">>>>> preHandler >>>>>");
		
		HttpSession session = request.getSession();
		Object loginUser = session.getAttribute("username");
		
		if(loginUser == null) {
			// 원래 가려던 URL을 세션에 저장
			String redirectURL = request.getRequestURI();
			System.out.println("원래 가려던 주소: " + redirectURL);
			
			
		}
		
		return true;
	}
}
