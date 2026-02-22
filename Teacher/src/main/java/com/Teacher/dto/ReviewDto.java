package com.Teacher.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {

    @NotBlank(message = "Review cannot be empty")
    private String review;

    @NotBlank(message = "Status is required")
    private String status;   // APPROVED / REJECTED
}
