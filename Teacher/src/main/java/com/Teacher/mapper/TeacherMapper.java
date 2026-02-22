package com.Teacher.mapper;

import com.Teacher.dto.ReviewDto;
import com.Teacher.dto.StudentDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    // Update review + status in StudentDto
    void updateReviewFromDto(ReviewDto reviewDto, @MappingTarget StudentDto studentDto);

}
