package com.company.repository.like;

import com.company.entity.like.CommentCourseLikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentPostLikeRepository extends JpaRepository<CommentCourseLikeEntity, String> {
}