package com.web.study.service;

import com.web.study.dto.request.auth.LoginReqDto;
import com.web.study.dto.request.auth.RegisterUserReqDto;
import com.web.study.dto.response.auth.JwtTokenRespDto;

public interface AuthService {
	
	public void registerUser(RegisterUserReqDto registerUserReqDto);
	public void duplicatedUsername(RegisterUserReqDto registerUserReqDto);
	
	public JwtTokenRespDto login(LoginReqDto loginReqDto);
}
