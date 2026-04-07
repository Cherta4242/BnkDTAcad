package com.example.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;

import com.example.jwt.JwtAuthFilter;


public class FilterConfig {

	private final JwtAuthFilter jwtAuthFilter;
	
	public FilterConfig(JwtAuthFilter jwtAuthFilter) {
		this.jwtAuthFilter = jwtAuthFilter;
	}
	
	public FilterRegistrationBean<JwtAuthFilter> jwtFilter(){
		FilterRegistrationBean<JwtAuthFilter> bean = new FilterRegistrationBean<>();
		
		bean.setFilter(jwtAuthFilter);
		bean.addUrlPatterns("/api/*");
		bean.setOrder(1);
		
		return bean;
	}
	
}
