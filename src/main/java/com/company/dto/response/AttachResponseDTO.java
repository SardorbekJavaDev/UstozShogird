package com.company.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Setter
@Getter
public class AttachResponseDTO {

    private String id;
    private String url;
    private String origenName;
    private LocalDateTime createdDate;
    private String path;
    private long size;

}
