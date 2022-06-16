package com.company.entity.like;

import com.company.entity.PostEntity;
import com.company.entity.UserEntity;
import com.company.entity.base.BaseEntity;
import com.company.enums.LikeType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "post_like")
public class PostLikeEntity extends BaseEntity {
    @Column
    @Enumerated(EnumType.STRING)
    private LikeType type;

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
