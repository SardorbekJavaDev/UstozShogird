package com.company.entity;

import com.company.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "comment_course_entity")
public class CommentCourseEntity extends BaseEntity {
    @Column
    private String content;

    @Column
    private String replyId;

    @Column(name = "user_id")
    private String userId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",insertable = false, updatable = false)
    private UserEntity user;

    @Column(name = "course_id")
    private String courseId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id",insertable = false, updatable = false)
    private CourseEntity course;

}
