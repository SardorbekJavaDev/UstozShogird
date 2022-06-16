package com.company.service;

import com.company.dto.LikeDTO;
import com.company.dto.request.PostRequestDTO;
import com.company.dto.response.PostResponseDTO;
import com.company.entity.PostEntity;
import com.company.enums.GenStatus;
import com.company.exp.AppForbiddenException;
import com.company.exp.ItemNotFoundException;
import com.company.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final TagService tagService;

    public PostResponseDTO create(PostRequestDTO dto, String pId) {
        PostEntity entity = saveEntity(dto,pId, new PostEntity());
        return toResponseDTO(entity);
    }

    private PostEntity saveEntity(PostRequestDTO dto, String pId, PostEntity entity) {
        entity.setAttachId(dto.getAttachId());
        entity.setPayment(dto.getPayment());
        entity.setProfession(dto.getProfession());
        entity.setPurpose(dto.getPurpose());
        entity.setTimeToApply(dto.getTimeToApply());
        entity.setUserId(pId);
        entity.setStatus(GenStatus.UNCHACKED);
        entity.setVisible(true);
        entity.setViewUsers(true);
        postRepository.save(entity);
        return entity;
    }

    public Boolean update(PostRequestDTO dto, String id, String pId) {
        PostEntity entity = getEntityById(id);
        if (!entity.getUserId().equals(pId)) {
            throw new AppForbiddenException("Not Belong You !");
        }
        saveEntity(dto, pId, entity);
        return true;
    }

    public Boolean delete(String id, String pId) {
        int n = postRepository.updateVisible(id,pId,false);
        return n > 0;
    }

    public PostResponseDTO getById(String id) {
        PostEntity entity = postRepository.findByIdAndVisibleTrue(id).orElseThrow(() -> {
            throw new ItemNotFoundException("Not found !");
        });
        return toResponseDTO(entity);
    }

    private PostResponseDTO toResponseDTO(PostEntity entity) {
        PostResponseDTO dto = new PostResponseDTO();
        dto.setLikeDTO(new LikeDTO());
        dto.setAttachId(entity.getAttachId());
        dto.setPayment(entity.getPayment());
        dto.setProfession(entity.getProfession());
        dto.setPurpose(entity.getPurpose());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setViewUsers(entity.getViewUsers());
        dto.setViewCount(entity.getViewCount());
        dto.setTimeToApply(entity.getTimeToApply());
        dto.setUserId(entity.getUserId());
        return dto;
    }

    private PostEntity getEntityById(String id) {
       return postRepository.findByIdAndVisibleTrue(id).orElseThrow(() -> {
            throw new ItemNotFoundException("Not found !");
        });
    }
}
