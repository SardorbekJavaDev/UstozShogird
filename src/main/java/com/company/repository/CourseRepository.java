package com.company.repository;

import com.company.entity.CourseEntity;
import com.company.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<CourseEntity, String> {
    @Transactional
    @Modifying
    @Query("update CourseEntity as c set c.visible = :visible where c.id = :id and c.userId = :pId")
    int updateVisible(@Param("id") String id, @Param("pId") String pId, @Param("visible") Boolean visible);


//    @Transactional
//    @Modifying
//    @Query("update PostEntity as p set p.visible = :visible where p.id = :id and p.userId = :pId")
//    int updateVisible(@Param("id") String id, @Param("pId") String pId, @Param("visible") Boolean visible);
    Optional<CourseEntity> findByIdAndVisibleTrue(String id);

}