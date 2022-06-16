package com.company.service.like;

import com.company.dto.request.CourseLikeRequestDTO;
import com.company.dto.response.CourseLikeResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseLikeService {
    public CourseLikeResponseDTO create(CourseLikeRequestDTO dto, String id) {
        return null;
    }

    public Boolean update(CourseLikeRequestDTO dto, String pId, String id) {
        return null;
    }

    public Boolean delete(String id, String pId) {
        return null;
    }

    public CourseLikeResponseDTO getById(String id) {
        return null;
    }
}
