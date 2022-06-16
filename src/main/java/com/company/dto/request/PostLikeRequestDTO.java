package com.company.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostLikeRequestDTO {
    private String type;
    private String postId;
}
