package com.company.entity;

import com.company.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "attach")
public class AttachEntity extends BaseEntity {
    private String path;
    private String extension;
    private String origenName;
    private Long size;
    private String id;
    private Boolean visible;
    private LocalDateTime createdDate = LocalDateTime.now();
    private LocalDateTime updatedDate;
    private LocalDateTime deletedDate;
}
