package com.company.repository;

import com.company.entity.CourseTagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseTagRepository extends JpaRepository<CourseTagEntity, String> {
}