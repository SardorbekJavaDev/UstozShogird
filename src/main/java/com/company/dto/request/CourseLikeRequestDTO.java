package com.company.dto.request;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CourseLikeRequestDTO {
    private String type;  // + or -
    private String courseId;
}
