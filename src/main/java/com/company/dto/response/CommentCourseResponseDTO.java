package com.company.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class CommentCourseResponseDTO {

    private String courseId;

    private String content;
    private String replyId;
    private LocalDateTime createdDate;

}
