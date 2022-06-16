package com.company.dto.request;

import com.company.enums.LikeType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class CommentPostLikeRequestDTO {
    private String type;  // + or -
    private String commentPostId;
}
