package com.Teacher.Controller;

import com.Teacher.dto.ReviewDto;
import com.Teacher.dto.StudentDto;
import com.Teacher.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    // Get all students
    @GetMapping("/students")
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        return ResponseEntity.ok(teacherService.getAllStudents());
    }

    // Get single student
    @GetMapping("/student/{rollNo}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable String rollNo) {
        return ResponseEntity.ok(teacherService.getStudentByRollNo(rollNo));
    }

    // Download assignment (FIXED → Resource)
    @GetMapping("/student/download/{rollNo}")
    public ResponseEntity<Resource> downloadAssignment(@PathVariable String rollNo) {

        Resource file = teacherService.downloadAssignment(rollNo);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=" + file.getFilename())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(file);
    }

    // Review + Update
    @PutMapping("/student/review/{rollNo}")
    public ResponseEntity<StudentDto> reviewStudent(
            @PathVariable String rollNo,
            @RequestBody ReviewDto reviewDto) {

        return ResponseEntity.ok(
                teacherService.reviewStudent(rollNo, reviewDto)
        );
    }
}
