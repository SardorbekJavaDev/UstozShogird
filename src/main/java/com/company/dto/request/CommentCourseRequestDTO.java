package com.company.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentCourseRequestDTO {
    private String courseId;

    private String content;
    private String replyId;
}
