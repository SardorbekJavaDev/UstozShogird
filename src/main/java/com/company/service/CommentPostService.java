package com.company.service;

import com.company.dto.request.CommentPostRequestDTO;
import com.company.dto.response.CommentPostResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentPostService {
    public CommentPostResponseDTO create(CommentPostRequestDTO dto, String id) {
        return null;
    }

    public Boolean update(CommentPostRequestDTO dto, String pId, String id) {
        return null;
    }

    public Boolean delete(String id, String pId) {
        return null;
    }


}
