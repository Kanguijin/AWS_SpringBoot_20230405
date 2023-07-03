package com.web.study.dto.response;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter // json이 외부로 가져가기 위해서 
@ToString
public class CourseRespDto {
	private int courseId;
	private LocalDate registerDate;
	private String lectureName;
	private int lecturePrice;	
	private String instructorName;
	private String studentName;
}
