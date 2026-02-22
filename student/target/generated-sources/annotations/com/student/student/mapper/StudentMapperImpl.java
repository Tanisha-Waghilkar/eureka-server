package com.student.student.mapper;

import com.student.student.dto.StudentDto;
import com.student.student.dto.StudentFileDto;
import com.student.student.entity.StudentEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-22T20:20:46+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.10 (Oracle Corporation)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public StudentEntity mapDtoToInfo(StudentFileDto studentFileDto) {
        if ( studentFileDto == null ) {
            return null;
        }

        StudentEntity studentEntity = new StudentEntity();

        studentEntity.setFirstName( studentFileDto.getFirstName() );
        studentEntity.setLastName( studentFileDto.getLastName() );
        studentEntity.setEmail( studentFileDto.getEmail() );
        studentEntity.setPhone( studentFileDto.getPhone() );

        return studentEntity;
    }

    @Override
    public StudentDto mapStudentInfoToStudentDto(StudentEntity studentEntity) {
        if ( studentEntity == null ) {
            return null;
        }

        StudentDto.StudentDtoBuilder studentDto = StudentDto.builder();

        studentDto.rollNo( studentEntity.getRollNo() );
        studentDto.firstName( studentEntity.getFirstName() );
        studentDto.lastName( studentEntity.getLastName() );
        studentDto.email( studentEntity.getEmail() );
        studentDto.phone( studentEntity.getPhone() );
        studentDto.review( studentEntity.getReview() );
        studentDto.status( studentEntity.getStatus() );
        studentDto.fileName( studentEntity.getFileName() );
        studentDto.filePath( studentEntity.getFilePath() );

        return studentDto.build();
    }

    @Override
    public StudentEntity mapStudentDtoToInfo(StudentDto studentDto) {
        if ( studentDto == null ) {
            return null;
        }

        StudentEntity studentEntity = new StudentEntity();

        studentEntity.setRollNo( studentDto.getRollNo() );
        studentEntity.setFirstName( studentDto.getFirstName() );
        studentEntity.setLastName( studentDto.getLastName() );
        studentEntity.setEmail( studentDto.getEmail() );
        studentEntity.setPhone( studentDto.getPhone() );
        studentEntity.setFileName( studentDto.getFileName() );
        studentEntity.setFilePath( studentDto.getFilePath() );
        studentEntity.setReview( studentDto.getReview() );
        studentEntity.setStatus( studentDto.getStatus() );

        return studentEntity;
    }
}
