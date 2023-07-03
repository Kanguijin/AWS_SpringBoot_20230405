package com.web.study.dto.request.auth;



import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.web.study.domain.entity.User;

import lombok.Data;

@Data
public class RegisterUserReqDto {
	private String username;
	private String password;
	private String name;
	private String email;
	
	// 비밀번호 암호화 
	public User toEntity() {
		return User.builder()
				.username(username)
				.password(new BCryptPasswordEncoder().encode(password))
				.name(name)
				.email(email)
				.build();
	}
}
