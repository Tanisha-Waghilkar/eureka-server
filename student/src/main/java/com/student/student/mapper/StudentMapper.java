package com.student.student.mapper;

import com.student.student.dto.StudentDto;
import com.student.student.dto.StudentFileDto;
import com.student.student.entity.StudentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    // Upload DTO → Entity
    StudentEntity mapDtoToInfo(StudentFileDto studentFileDto);

    // Entity → DTO
    StudentDto mapStudentInfoToStudentDto(StudentEntity studentEntity);

    // DTO → Entity (for update/review)
    StudentEntity mapStudentDtoToInfo(StudentDto studentDto);
}