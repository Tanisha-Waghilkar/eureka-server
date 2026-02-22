package com.Teacher.service.impl;

import com.Teacher.dto.ReviewDto;
import com.Teacher.dto.StudentDto;
import com.Teacher.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final RestTemplate restTemplate;

    @Value("${student.service.url}")
    private String studentServiceUrl;

    // 🔹 Get All Students
    @Override
    public List<StudentDto> getAllStudents() {
        ResponseEntity<StudentDto[]> response =
                restTemplate.getForEntity(
                        studentServiceUrl + "/api/v1/student",
                        StudentDto[].class
                );

        StudentDto[] body = response.getBody();
        return body != null ? Arrays.asList(body) : Collections.emptyList();
    }

    // 🔹 Get Student by RollNo
    @Override
    public StudentDto getStudentByRollNo(String rollNo) {
        return restTemplate.getForObject(
                studentServiceUrl + "/api/v1/student/" + rollNo,
                StudentDto.class
        );
    }

    // 🔹 Download Assignment File
    @Override
    public Resource downloadAssignment(String rollNo) {
        byte[] fileBytes = restTemplate.getForObject(
                studentServiceUrl + "/api/v1/student/download/" + rollNo,
                byte[].class
        );

        if (fileBytes == null) {
            throw new RuntimeException("File not found for rollNo: " + rollNo);
        }

        return new ByteArrayResource(fileBytes);
    }

    // 🔹 Review Student
    @Override
    public StudentDto reviewStudent(String rollNo, ReviewDto reviewDto) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<ReviewDto> request = new HttpEntity<>(reviewDto, headers);

        ResponseEntity<StudentDto> response = restTemplate.exchange(
                studentServiceUrl + "/api/v1/student/review/" + rollNo,
                HttpMethod.PUT,
                request,
                StudentDto.class
        );

        return response.getBody();
    }
}
