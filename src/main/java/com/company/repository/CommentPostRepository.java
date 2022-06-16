package com.company.repository;

import com.company.entity.CommentPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentPostRepository extends JpaRepository<CommentPostEntity, String> {
}