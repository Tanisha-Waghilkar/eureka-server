package com.student.student.controller;

import com.student.student.dto.StudentDto;
import com.student.student.dto.StudentFileDto;
import com.student.student.service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    // 🔹 Upload Student + File
    @PostMapping
    public ResponseEntity<StudentDto> addStudent(
            @Valid @ModelAttribute StudentFileDto studentFileDto) throws IOException {

        StudentDto studentDto = studentService.addStudent(studentFileDto);
        return ResponseEntity.ok(studentDto);
    }

    // 🔹 Get Student by Roll No
    @GetMapping("/{rollNo}")
    public ResponseEntity<StudentDto> getById(@PathVariable String rollNo) {

        StudentDto studentDto = studentService.getById(rollNo);
        return ResponseEntity.ok(studentDto);
    }

    // Delete Student
    @DeleteMapping("/{rollNo}")
    public ResponseEntity<String> deleteStudent(@PathVariable String rollNo) {
        String msg = studentService.deleteStudent(rollNo);
        return ResponseEntity.ok(msg);
    }

    // 🔹 Download Student File
    @GetMapping("/download/{rollNo}")
    public ResponseEntity<Resource> downloadInfo(@PathVariable String rollNo) throws IOException {

        Resource resource = studentService.downloadFile(rollNo);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
