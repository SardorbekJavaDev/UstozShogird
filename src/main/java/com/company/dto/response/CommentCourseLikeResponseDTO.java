package com.company.dto.response;

import com.company.enums.LikeType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class CommentCourseLikeResponseDTO {
    private  String type;
    private  String commentCourseId;
    private  LocalDateTime createdDate;
}
