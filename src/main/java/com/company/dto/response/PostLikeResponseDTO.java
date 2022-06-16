package com.company.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class PostLikeResponseDTO {
    private LocalDateTime createdDate;
    private String type;
    private String postId;
}
