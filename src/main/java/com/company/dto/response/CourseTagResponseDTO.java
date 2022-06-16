package com.company.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.time.LocalDateTime;

@Setter
@Getter
public class CourseTagResponseDTO {

    private String courseId;
    private List<String> tagList;
    private LocalDateTime createdDate;

}
