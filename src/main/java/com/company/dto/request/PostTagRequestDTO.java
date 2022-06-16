package com.company.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostTagRequestDTO {
    private String postId;
    private List<String> tagList;
    private LocalDateTime createdDate;

}
