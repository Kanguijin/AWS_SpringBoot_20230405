package com.web.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.web.study.security.jwt.JwtAuthenticationEntryPoint;
import com.web.study.security.jwt.JwtAuthenticationFilter;
import com.web.study.security.jwt.JwtTokenProvider;

import lombok.RequiredArgsConstructor;

@EnableWebSecurity // Spring Security 활성화
@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private final JwtTokenProvider jwtTokenProvider;
	private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// Security filter
	// http 요청에 대한 보안구성을 정의
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable(); // CSRF 보호 기능 비활성화
		http.httpBasic().disable(); // 웹 기본 인증 방식
		http.formLogin().disable(); // 폼 태그를 통한 로그인
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // 세션 비활성화
		http.authorizeRequests() // 요청에 대한 인증 및 권한부여 구성
			.antMatchers("/auth/register/**", "/auth/login/**") // Security Context가 없어도 됨.
			.permitAll()
			.antMatchers("/courses")
			.hasRole("ADMIN")
			.anyRequest() // Security Context가 있어야 함
			.authenticated() // security Context 뿐만 아니라 authenticate값도 있어야함. 인증과정
			.and()
			.addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class)
			.exceptionHandling()
			.authenticationEntryPoint(jwtAuthenticationEntryPoint);
	}
}
