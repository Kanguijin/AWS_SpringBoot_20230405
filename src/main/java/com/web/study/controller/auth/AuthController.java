package com.web.study.controller.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.study.dto.DataResponseDto;
import com.web.study.dto.ResponseDto;
import com.web.study.dto.request.auth.LoginReqDto;
import com.web.study.dto.request.auth.RegisterUserReqDto;
import com.web.study.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthController {
	
	private final AuthService authService;
	
	@PostMapping("/auth/register")
	public ResponseEntity<? extends ResponseDto> registe(@RequestBody RegisterUserReqDto registerUserReqDto) {
		authService.duplicatedUsername(registerUserReqDto); // 아이디 중복확인 
		authService.registerUser(registerUserReqDto);
		return ResponseEntity.ok().body(ResponseDto.ofDefault());
	}
	
	@PostMapping("/auth/login")
	public ResponseEntity<? extends ResponseDto> login(@RequestBody LoginReqDto loginReqDto) {
		
        authService.login(loginReqDto);                        
		// jwt 토큰 받음 
		return ResponseEntity.ok().body(DataResponseDto.of(authService.login(loginReqDto)));
	}
}
