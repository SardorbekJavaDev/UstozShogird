package com.company.repository;

import com.company.entity.UserEntity;
import com.company.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, String> {

    @Transactional
    @Modifying
    @Query("update UserEntity as u set u.visible = :visible where u.id = :id ")
    int updateVisible(@Param("id") String id, @Param("visible") Boolean visible);

    @Transactional
    @Modifying
    @Query("update UserEntity as u set u.role = :role where u.id = :id ")
    int updateUserRole(@Param("id") String id, @Param("role") UserRole role);

    Optional<UserEntity> findByPhone(String phone);
}