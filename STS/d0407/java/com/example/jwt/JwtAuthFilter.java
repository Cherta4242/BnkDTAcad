package com.example.jwt;

import java.io.IOException;

import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@Component
public class JwtAuthFilter extends OncePerRequestFilter{

	private final JwtUtil jwtUtil;
	
	public JwtAuthFilter(JwtUtil jwtUtil) {
		this.jwtUtil = jwtUtil;
	}
	
	
	@Override
	protected void doFilterInternal(
			HttpServletRequest request, 
			HttpServletResponse response, 
			FilterChain filterChain) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		
//		/api/** 경로만 토큰 검사
		if(!uri.startsWith("/api/")) {
			filterChain.doFilter(request,  response);
			return;
		}
		
//		authorization 헤더에서 토큰 추출
		String header = request.getHeader("Authorization");
		if(header == null || !header.startsWith("Bearer ")) {
			sendError(response, "Oops!! 토큰이 없어요.");
			return;
		}
		
		String token = header.substring(7);
		
//		토큰 유효성 검사
		if(!jwtUtil.isValid(token)) {
			sendError(response, "Oops!! 토큰이 만료되었거나 유효하지 않아요!");
			return;
		}
		
		filterChain.doFilter(request, response);
		
		
	}
	
	private void sendError(HttpServletResponse response, String message) throws IOException{
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().write("{\"message\": \"" + message + "\"}");
	}

	
}
