package com.company.service;

import com.company.dto.request.CourseRequestDTO;
import com.company.dto.response.CourseResponseDTO;
import com.company.entity.CourseEntity;
import com.company.enums.GenStatus;
import com.company.exp.AppForbiddenException;
import com.company.exp.ItemNotFoundException;
import com.company.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TagService tagService;

    public CourseResponseDTO create(CourseRequestDTO dto, String pId) {
        CourseEntity entity = saveEntity(dto, pId, new CourseEntity());
        return toResponseDTO(entity);
    }

    public Boolean update(CourseRequestDTO dto, String pId, String id) {
        CourseEntity entity = getEntityById(id);     // TODO: 13.06.2022 Birinchi tekshirib keyin update qilgan yaxshimi yoki birdan bitta queryda update qilvorgan yaxshimi
        if (!entity.getUserId().equals(pId)) {
            throw new AppForbiddenException("Not Belong You !");
        }
        saveEntity(dto,pId,entity);
        return true;
    }

    public Boolean delete(String id, String pId) {
//        int n = courseRepository.updateVisible(id, pId, false);
//        return n > 0;
        return true;
    }

    public CourseResponseDTO getById(String id) {
        CourseEntity entity = courseRepository.findByIdAndVisibleTrue(id).orElseThrow(() -> {
            throw new ItemNotFoundException("Not Found !");
        });
        return toResponseDTO(entity);
    }


    private CourseEntity saveEntity(CourseRequestDTO dto, String pId, CourseEntity entity) {
        entity.setUserId(pId);
        entity.setOfficeName(dto.getOfficeName());
        entity.setDefinition(dto.getDefinition());
        entity.setDescription(dto.getDescription());
        entity.setDestination(dto.getDestination());
        entity.setAttachId(dto.getAttachId());
        entity.setTimeToApply(dto.getTimeToApply());
        entity.setLocation(dto.getLocation());
        entity.setPayment(dto.getPayment());
        entity.setPurpose(dto.getPurpose());
        entity.setStatus(GenStatus.UNCHACKED);
        entity.setVisible(true);
        entity.setViewUsers(true);
        courseRepository.save(entity);
        return entity;
    }

    private CourseResponseDTO toResponseDTO(CourseEntity entity) {
        CourseResponseDTO dto = new CourseResponseDTO();
        dto.setId(entity.getId());
        dto.setUserId(entity.getUserId());
        dto.setOfficeName(entity.getOfficeName());
        dto.setDefinition(entity.getDefinition());
        dto.setDescription(entity.getDescription());
        dto.setDestination(entity.getDestination());
        dto.setAttachId(entity.getAttachId());
        dto.setTimeToApply(entity.getTimeToApply());
        dto.setLocation(entity.getLocation());
        dto.setPayment(entity.getPayment());
        dto.setPurpose(entity.getPurpose());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setViewCount(entity.getViewCount());
        dto.setViewUsers(entity.getViewUsers());
        return dto;
    }

    private CourseEntity getEntityById(String id) {
        return courseRepository.findByIdAndVisibleTrue(id).orElseThrow(() -> {
            throw new ItemNotFoundException("Not Found !");
        });
    }


}
