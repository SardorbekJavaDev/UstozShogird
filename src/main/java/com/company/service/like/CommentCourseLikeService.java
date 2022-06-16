package com.company.service.like;

import com.company.dto.request.CommentCourseLikeRequestDTO;
import com.company.dto.response.CommentCourseLikeResponseDTO;
import com.company.entity.like.CommentCourseLikeEntity;
import com.company.enums.LikeType;
import com.company.exp.ItemNotFoundException;
import com.company.repository.like.CommentCourseLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentCourseLikeService {

    CommentCourseLikeRepository commentCourseLikeRepository;

    public CommentCourseLikeResponseDTO create(CommentCourseLikeRequestDTO dto, String pId) {
        LikeType likeType = null;
        if (dto.getType().equals("+"))
            likeType = LikeType.LIKE;
        else if (dto.getType().equals("-")) {
            likeType = LikeType.DISLIKE;
        }

        CommentCourseLikeEntity entity = commentCourseLikeRepository.findByUserIdAndCommentCourseId(pId, dto.getCommentCourseId());
        CommentCourseLikeResponseDTO response = new CommentCourseLikeResponseDTO();
        if (entity == null) {
            entity = new CommentCourseLikeEntity();
            entity.setUserId(pId);
            entity.setCommentCourseId(dto.getCommentCourseId());
            entity.setType(likeType);
            commentCourseLikeRepository.save(entity);
        } else {
            if (likeType != null) {
                if ((entity.getType().equals(LikeType.LIKE) && likeType.equals(LikeType.LIKE)) ||
                        (entity.getType().equals(LikeType.DISLIKE) && likeType.equals(LikeType.DISLIKE))
                ) {
                    response.setCommentCourseId(entity.getCommentCourseId());
                    response.setType(entity.getType().toString());
                    response.setCreatedDate(entity.getCreatedDate());
                } else {
                    commentCourseLikeRepository.updateType(pId, dto.getCommentCourseId(), likeType);
                }
            }
        }


        return response;
    }

    public Boolean delete(String id, String pId) {
        int n = commentCourseLikeRepository.updateVisible(id, pId, false);
        return n > 0;
    }

    public CommentCourseLikeEntity getById(String id) {
        commentCourseLikeRepository.findById(id).orElseThrow(() -> {
            throw new ItemNotFoundException("Not found !");
        });
        return null;
    }
}
