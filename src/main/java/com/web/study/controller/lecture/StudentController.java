package com.web.study.controller.lecture;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.study.dto.DataResponseDto;
import com.web.study.dto.ResponseDto;
import com.web.study.dto.request.student.StudentReqDto;
import com.web.study.service.StudentService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class StudentController {
   
   private final StudentService studentService;
   
   // @RequestBody => 클라이언트 -> 서버 데이터 전송(JSON)
   // JSON의 형태 -> 객체

   @PostMapping("/student")
   public ResponseEntity<? extends ResponseDto> registStudent(@RequestBody StudentReqDto studentReqDto) {
      
      studentService.registStudent(studentReqDto);
      
      return ResponseEntity.ok().body(ResponseDto.ofDefault());
   }
   
   @GetMapping("/students")
   public ResponseEntity<? extends ResponseDto> getStudentAll() {
      return ResponseEntity.ok().body(DataResponseDto.of(studentService.getStudentAll()));
   }
   
   @GetMapping("/student/{id}")
	public ResponseEntity<? extends ResponseDto> getStudentById(@PathVariable int id) {
	
		return ResponseEntity.ok().body(DataResponseDto.of(studentService.findStudentById(id)));
	}
}
		