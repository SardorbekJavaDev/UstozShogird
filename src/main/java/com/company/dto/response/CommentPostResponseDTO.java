package com.company.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class CommentPostResponseDTO {

    private String content;
    private String replyId;
    private String postId;
    private LocalDateTime createdDate;

}
