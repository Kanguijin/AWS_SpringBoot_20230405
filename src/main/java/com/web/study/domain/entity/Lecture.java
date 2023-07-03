package com.web.study.domain.entity;

import com.web.study.dto.response.LectureRespDto;

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
public class Lecture {
	private int ltm_id;
	private String ltm_name;
	private int ltm_price;
	private int itm_id; 
	private Instructor instructor;
	
	public LectureRespDto toDto() {
		String instructor_Name = null;
		
		if(instructor != null) {
			instructor_Name = instructor.getItm_name();
		}
		return LectureRespDto.builder()
				.lectureId(ltm_id)
				.lectureName(ltm_name)
				.lecturePrice(ltm_price)
				.instructorName(instructor_Name)
				.build();
				
	}
}
