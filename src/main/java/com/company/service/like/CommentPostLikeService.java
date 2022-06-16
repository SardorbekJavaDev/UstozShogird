package com.company.service.like;

import com.company.dto.request.CommentPostLikeRequestDTO;
import com.company.dto.response.CommentPostLikeResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentPostLikeService {
    public CommentPostLikeResponseDTO create(CommentPostLikeRequestDTO dto, String id) {
        return null;
    }

    public Boolean update(CommentPostLikeRequestDTO dto, String pId, String id) {
        return true;
    }

    public Boolean delete(String id, String pId) {
        return true;
    }

    public CommentPostLikeResponseDTO getById(String id) {
        return null;
    }
}
