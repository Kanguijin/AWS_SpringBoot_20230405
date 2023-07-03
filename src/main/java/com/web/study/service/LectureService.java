package com.web.study.service;

import java.util.List;

import com.web.study.dto.request.lecture.LectureReqDto;
import com.web.study.dto.response.LectureRespDto;

public interface LectureService {
	public void registerLecture(LectureReqDto lectureReqDto);
	public List<LectureRespDto> searchLecture(int type, String searchValue);
}
