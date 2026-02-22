package com.Teacher.mapper;

import com.Teacher.dto.ReviewDto;
import com.Teacher.dto.StudentDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-22T23:05:40+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.10 (Oracle Corporation)"
)
@Component
public class TeacherMapperImpl implements TeacherMapper {

    @Override
    public void updateReviewFromDto(ReviewDto reviewDto, StudentDto studentDto) {
        if ( reviewDto == null ) {
            return;
        }

        studentDto.setReview( reviewDto.getReview() );
        studentDto.setStatus( reviewDto.getStatus() );
    }
}
