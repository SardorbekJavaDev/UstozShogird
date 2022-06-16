package com.company.service.like;

import com.company.dto.request.PostLikeRequestDTO;
import com.company.dto.response.PostLikeResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostLikeService {
    public Boolean delete(String id, String pId) {
        return true;
    }

    public Boolean update(PostLikeRequestDTO dto, String pId, String id) {
        return true;
    }

    public PostLikeResponseDTO create(PostLikeRequestDTO dto, String id) {
        return null;
    }
}
