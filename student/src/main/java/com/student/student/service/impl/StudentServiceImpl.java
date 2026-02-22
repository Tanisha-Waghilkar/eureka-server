package com.student.student.service.impl;

import com.student.student.dto.ReviewDto;
import com.student.student.dto.StudentDto;
import com.student.student.dto.StudentFileDto;
import com.student.student.entity.StudentEntity;
import com.student.student.exception.StudentEmailAlreadyExistsException;
import com.student.student.mapper.StudentMapper;
import com.student.student.repository.StudentRepository;
import com.student.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Value("${file.upload-dir}")
    private String uploadDirectory;

    // ================= ADD STUDENT =================
    @Override
    @Transactional
    public StudentDto addStudent(StudentFileDto dto) throws IOException {

        if (studentRepository.existsByEmail(dto.getEmail())) {
            throw new StudentEmailAlreadyExistsException("Email already exists");
        }

        if (studentRepository.existsByPhone(dto.getPhone())) {
            throw new RuntimeException("Phone already exists");
        }

        String filename = dto.getFile().getOriginalFilename();

        // DTO → Entity
        StudentEntity student = studentMapper.mapDtoToInfo(dto);
        student.setFileName(filename);
        student.setReview("Under Review");
        student.setStatus("UPLOADED");
        student.setFilePath(uploadDirectory + "/" + filename);

        File dir = new File(uploadDirectory);
        if (!dir.exists()) dir.mkdirs();

        dto.getFile().transferTo(new File(dir, filename));

        studentRepository.save(student);

        // Entity → DTO
        return studentMapper.mapStudentInfoToStudentDto(student);
    }

    // ================= GET ALL =================
    @Override
    public List<StudentDto> getAllStudent() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::mapStudentInfoToStudentDto)
                .collect(Collectors.toList());
    }

    // ================= GET BY ID =================
    @Override
    public StudentDto getById(String rollStr) {
        Long id = validate(rollStr);

        StudentEntity student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        return studentMapper.mapStudentInfoToStudentDto(student);
    }

    // ================= DELETE =================
    @Override
    public String deleteStudent(String rollStr) {
        Long id = validate(rollStr);
        studentRepository.deleteById(id);
        return "Student deleted successfully";
    }

    // ================= DOWNLOAD FILE =================
    @Override
    public Resource downloadFile(String rollStr) throws IOException {
        Long id = validate(rollStr);

        StudentEntity student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Path path = Paths.get(uploadDirectory, student.getFileName());
        return new UrlResource(path.toUri());
    }

    // ================= REVIEW / UPDATE =================
    @Override
    public StudentDto updateStudent(String rollStr, ReviewDto reviewDto) {
        Long id = validate(rollStr);

        StudentEntity student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setReview(reviewDto.getReview());
        student.setStatus(reviewDto.getStatus());

        studentRepository.save(student);

        return studentMapper.mapStudentInfoToStudentDto(student);
    }

    // ================= VALIDATE ID =================
    private Long validate(String value) {
        if (!Pattern.matches("^\\d+$", value)) {
            throw new RuntimeException("Invalid student id");
        }
        return Long.parseLong(value);
    }
}