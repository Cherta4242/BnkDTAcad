package com.example.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.example.auth.MemberDetailsService;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	private final DataSource dataSource;
	private final MemberDetailsService userDetailsService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncode() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.csrf(auth -> auth.disable());
		
		http.authorizeHttpRequests(auth -> auth
					.requestMatchers("/", "/regist", "/login", "/registProc").permitAll()
					.requestMatchers("/members/**").hasAnyRole("ADMIN", "MEMBER")
					.requestMatchers("/admin").hasRole("ADMIN")
					.anyRequest().authenticated()
					);
		
		http.formLogin(auth -> auth
					.loginPage("/login")
					.loginProcessingUrl("/loginProc")
					.defaultSuccessUrl("/success", true)
					.failureUrl("/login?error")
//					.usernameParameter("id")
//					.passwordParameter("pw")
				);
		
		http.logout(logout -> logout
					.logoutUrl("/logout")
					.logoutSuccessUrl("/login?logout")
				);
		
		http.rememberMe(auth -> auth
					.key("12345678")
					.tokenRepository(persistentTokenRepository())
					.userDetailsService(userDetailsService)
					.tokenValiditySeconds(60 * 3)	// 3분(유지)
				);
		
		
		
		return http.build();
	}
	
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
		repo.setDataSource(dataSource);
		
		return repo;
		
	}
	
	
}
