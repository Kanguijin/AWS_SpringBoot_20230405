package com.web.study.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.web.study.dto.ErrorResponseDto;
import com.web.study.exception.CustomException;

@RestControllerAdvice // 예외처리용 컨트롤러
public class ApiControllerAdvice {
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorResponseDto> error(CustomException e) {
		return ResponseEntity.badRequest().body(
				ErrorResponseDto.of(
						HttpStatus.BAD_REQUEST, 
						e, 
						e.getErrorMap()));
	}
}
