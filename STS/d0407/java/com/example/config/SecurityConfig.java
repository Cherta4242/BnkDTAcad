package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.jwt.JwtAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	
	private final JwtAuthenticationFilter jwtAuthenticationFilter;
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
//		세션 사용 안함(JWT는 STATELESS)
		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
//		CSRF 비활성 - REST API는 불필요
		http.csrf(csrf -> csrf.disable());
//		기본 폼 로그인 비활성
		http.formLogin(form -> form.disable());
		http.httpBasic(AbstractHttpConfigurer::disable);
		
		http.authorizeHttpRequests(auth -> auth
					.requestMatchers("/login").permitAll()
					.requestMatchers("/api/member/**").hasRole("MEMBER")
					.requestMatchers("/api/admin/**").hasRole("ADMIN")
					.anyRequest().authenticated()
				);
		
//		JwtAuthenticationFilter를 UsernamePasswordAuthenticationFilter 앞에 삽입
		http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
		
		
		
		
		return http.build();
	}
}
