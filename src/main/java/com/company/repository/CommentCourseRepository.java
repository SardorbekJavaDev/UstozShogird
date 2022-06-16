package com.company.repository;

import com.company.entity.like.CommentCourseLikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentCourseRepository extends JpaRepository<CommentCourseLikeEntity, String> {
}
