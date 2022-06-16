package com.company.repository;

import com.company.entity.PostTagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostTagRepository extends JpaRepository<PostTagEntity, String> {
}