package com.Teacher.service;

import com.Teacher.dto.ReviewDto;
import com.Teacher.dto.StudentDto;
import org.springframework.core.io.Resource;

import java.util.List;

public interface TeacherService {

    List<StudentDto> getAllStudents();

    StudentDto getStudentByRollNo(String rollNo);

    Resource downloadAssignment(String rollNo);

    StudentDto reviewStudent(String rollNo, ReviewDto reviewDto);
}
