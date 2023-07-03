package com.web.study.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.study.dto.DataResponseDto;
import com.web.study.dto.ErrorResponseDto;
import com.web.study.dto.ResponseDto;
import com.web.study.dto.request.SearchDto;
import com.web.study.dto.request.StudentDto;


@RestController
public class BasicRestController2 {
	@GetMapping("/search")
	public ResponseEntity<? extends ResponseDto> search(String id) {
		
		if(id==null) {
				return ResponseEntity.internalServerError().body(ErrorResponseDto.of(HttpStatus.INTERNAL_SERVER_ERROR));
		}
		return ResponseEntity.ok().body(DataResponseDto.of(id));
	}
	
	@GetMapping("/search2")
	public ResponseEntity<? extends ResponseDto> search2(SearchDto searchDto) {
		String loginUserInfo = searchDto.getId() + "(" + searchDto.getPassword()+ ")";
		
		return ResponseEntity.ok().body(DataResponseDto.of(loginUserInfo));
	}
	@PostMapping("/create2")
	public ResponseEntity<? extends ResponseDto> create(@RequestBody StudentDto studentDto) {
		Map<String, String> studentInfo = new HashMap<>();
		studentInfo.put("학번", studentDto.getCode());
		studentInfo.put("이름", studentDto.getName());
		studentInfo.put("학년", studentDto.getGrade());
		return ResponseEntity.created(null).body(DataResponseDto.of(studentInfo));
	}
}
