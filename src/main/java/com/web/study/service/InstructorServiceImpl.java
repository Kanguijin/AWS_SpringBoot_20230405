package com.web.study.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.web.study.dto.request.instructor.InstructorReqDto;
import com.web.study.dto.response.InstructorRespDto;
import com.web.study.repository.InstructorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService{

	private final InstructorRepository instructorRepository;

	@Override
	public void registerInstructor(InstructorReqDto instructorReqDto) {
		instructorRepository.register(instructorReqDto.toEntity());
	}

	@Override
	public List<InstructorRespDto> getInstructorAll() {
		List<InstructorRespDto> dtos = new ArrayList<>();
		instructorRepository.getInstructorAll().forEach(entity -> {
			dtos.add(entity.toDto());
		});
		
		return dtos;
	}

	@Override
	public InstructorRespDto findInstructorById(int id) {
		
		return instructorRepository.findInstructorById(id).toDto();
	}
}
