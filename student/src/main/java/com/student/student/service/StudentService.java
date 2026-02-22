package com.student.student.service;

import com.student.student.dto.ReviewDto;
import com.student.student.dto.StudentDto;
import com.student.student.dto.StudentFileDto;
import jakarta.validation.Valid;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.List;

public interface StudentService {

    // Student uploads file + info
    StudentDto addStudent(@Valid StudentFileDto studentFileDto) throws IOException;

    // Get all students (used by teacher)
    List<StudentDto> getAllStudent();

    // Get student by roll number
    StudentDto getById(String rollNoStr);

    // Delete student
    String deleteStudent(String rollNoStr);

    // Download student file
    Resource downloadFile(String rollNoStr) throws IOException;

    // Update review + status (called by teacher)
    StudentDto updateStudent(String rollNoStr, ReviewDto reviewDto);
}
