package com.company.service;

import com.company.dto.request.CommentCourseRequestDTO;
import com.company.dto.response.CommentCourseResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentCourseService {
    public CommentCourseResponseDTO create(CommentCourseRequestDTO dto, String id) {
        return null;
    }

    public Boolean update(CommentCourseRequestDTO dto, String pId, String id) {
        return null;
    }

    public Boolean delete(String id, String pId) {
        return null;
    }
}
