package com.web.study.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.web.study.domain.entity.Lecture;

@Mapper
public interface LectureRepository {
	public int register(Lecture lecture);
	public List<Lecture> searchLecture(Map<String, Object> parameterMap);
}
