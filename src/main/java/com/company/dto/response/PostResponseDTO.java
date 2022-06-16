package com.company.dto.response;

import com.company.dto.LikeDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
public class PostResponseDTO {

    private String userId;
    private String attachId;
    private String payment;
    private String profession;
    private String timeToApply;
    private String purpose;

    private Integer viewCount;
    private LikeDTO likeDTO;
    private Boolean viewUsers;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

}
