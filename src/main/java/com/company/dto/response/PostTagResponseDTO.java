package com.company.dto.response;

import com.company.entity.PostEntity;
import com.company.entity.TagEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class PostTagResponseDTO {
    private String postId;
    private List<String> tagList;
    private LocalDateTime createdDate;

}
