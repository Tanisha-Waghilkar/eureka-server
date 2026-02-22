package com.Teacher.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private Long rollNo;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String review;
    private String status;
    private String fileName;
    private String filePath;
}
