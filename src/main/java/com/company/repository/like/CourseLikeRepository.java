package com.company.repository.like;

import com.company.entity.like.CourseLikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseLikeRepository extends JpaRepository<CourseLikeEntity, String> {
}