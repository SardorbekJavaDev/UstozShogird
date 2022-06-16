package com.company.repository.like;

import com.company.entity.like.CommentCourseLikeEntity;
import com.company.enums.LikeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface CommentCourseLikeRepository extends JpaRepository<CommentCourseLikeEntity, String> {

    @Transactional
    @Modifying
    @Query("update CommentCourseLikeEntity as c set c.visible = :visible where c.id = :id and c.userId = :pId")
    int updateVisible(@Param("id") String id, @Param("pId") String pId, @Param("visible") Boolean visible);

    CommentCourseLikeEntity findByUserIdAndCommentCourseId(String pId, String commentCourseId);

    @Transactional
    @Modifying
    @Query("update CommentCourseLikeEntity as c set c.type = :type where c.id = :id and c.userId = :pId")
    void updateType(@Param("pId") String pId, @Param("id") String id, @Param("type") LikeType type);
}