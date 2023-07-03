package com.web.study.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.web.study.domain.entity.Instructor;
import com.web.study.domain.entity.Student;

@Mapper
public interface StudentRepository {
   public int saveStudent(Student student);
   public List<Student> getStudentAll();
   public Student findStudentById(int id);
}
