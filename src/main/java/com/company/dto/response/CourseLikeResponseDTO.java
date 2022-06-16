package com.company.dto.response;

import com.company.enums.LikeType;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CourseLikeResponseDTO {
    private LocalDateTime createdDate;
    private String type;
    private String courseId;
}
