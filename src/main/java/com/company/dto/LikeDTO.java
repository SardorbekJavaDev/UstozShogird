package com.company.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LikeDTO {
    private Integer likeCount;
    private Integer disLikeCount;
    private Boolean isUserLiked;
    private Boolean isUserDisliked;
}
