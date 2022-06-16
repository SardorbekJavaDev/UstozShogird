package com.company.dto.response;

import com.company.dto.LikeDTO;
import com.company.entity.AttachEntity;
import com.company.entity.UserEntity;
import com.company.enums.GenStatus;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
public class CourseResponseDTO {
    private String id;
    private String userId;
    private String attachId;
    private String officeName;
    private String location;
    private String timeToApply;
    private String destination;
    private String description;
    private String definition;
    private String payment;
    private String purpose;
    private Boolean viewUsers;  //admin
    private Integer viewCount;
    private LikeDTO likeDTO;


    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
