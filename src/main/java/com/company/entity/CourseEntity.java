package com.company.entity;

import com.company.entity.base.BaseEntity;
import com.company.entity.base.PosterBaseEntity;
import com.company.enums.GenStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "course_entity")
public class CourseEntity extends PosterBaseEntity {

    @Column(nullable = false)
    private String officeName;
    @Column(nullable = false)
    private String location;
    @Column(nullable = false)
    private String destination;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String definition;


}
