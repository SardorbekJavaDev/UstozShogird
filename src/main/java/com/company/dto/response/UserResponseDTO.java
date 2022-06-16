package com.company.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserResponseDTO {
    private String id;
    private String name;
    private String surname;
    private String phone;
    private String attachId;
    private LocalDateTime createdDate;

}
