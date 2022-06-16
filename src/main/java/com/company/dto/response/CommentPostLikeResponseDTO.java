package com.company.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class CommentPostLikeResponseDTO {
    private String type;
    private String commentPostId;
    private LocalDateTime createdDate;
}
