package com.web.study.domain.entity;

import java.time.LocalDate;

import com.web.study.dto.response.InstructorRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Instructor {
	private int itm_id;
	private String itm_name;
	private LocalDate itm_birth;
	
	public InstructorRespDto toDto() {
		return InstructorRespDto.builder()
				.id(itm_id)
				.name(itm_name)
				.birthDate(itm_birth)
				.build();
	}
	
}
