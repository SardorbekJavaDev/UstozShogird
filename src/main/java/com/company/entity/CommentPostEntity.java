package com.company.entity;

import com.company.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "comment_post_entity")
public class CommentPostEntity extends BaseEntity {
    @Column
    private String content;

    @Column
    private String replyId;

    @Column(name = "user_id")
    private String userId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",insertable = false, updatable = false)
    private UserEntity user;

    @Column(name = "post_id")
    private String postId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id",insertable = false, updatable = false)
    private PostEntity post;

}
