package com.company.entity.like;

import com.company.entity.CommentCourseEntity;
import com.company.entity.UserEntity;
import com.company.entity.base.BaseEntity;
import com.company.enums.LikeType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "comment_course_like")
public class CommentCourseLikeEntity extends BaseEntity {
    @Column
    @Enumerated(EnumType.STRING)
    private LikeType type;

    @Column(name = "user_id")
    private String userId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",insertable = false, updatable = false)
    private UserEntity user;

    @Column(name = "comment_course_id")
    private String commentCourseId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_course_id",insertable = false, updatable = false)
    private CommentCourseEntity commentCourse;
}
