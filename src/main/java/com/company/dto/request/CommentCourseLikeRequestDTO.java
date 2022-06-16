package com.company.dto.request;

import com.company.enums.LikeType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentCourseLikeRequestDTO {
    private String type;  // + or -
    private  String commentCourseId;
}
