package com.company.service;

import com.company.dto.request.UserRequestDTO;
import com.company.dto.response.UserResponseDTO;
import com.company.entity.CourseEntity;
import com.company.entity.UserEntity;
import com.company.enums.UserRole;
import com.company.enums.UserStatus;
import com.company.exp.AppForbiddenException;
import com.company.exp.ItemNotFoundException;
import com.company.exp.PhoneIsAlreadyBusy;
import com.company.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.rmi.AlreadyBoundException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDTO create(UserRequestDTO dto) {
        Optional<UserEntity> optional = userRepository.findByPhone(dto.getPhone());
        if (optional.isPresent()) throw new PhoneIsAlreadyBusy("This Phone Is Already Busy !");
        UserEntity entity = saveEntity(dto, new UserEntity());
        return toResponseDTO(entity);
    }

    private UserResponseDTO toResponseDTO(UserEntity entity) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setPhone(entity.getPhone());
        dto.setAttachId(entity.getAttachId());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }

    private UserEntity saveEntity(UserRequestDTO dto, UserEntity entity) {
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setPhone(dto.getPhone());
        entity.setAttachId(dto.getAttachId());
        entity.setVisible(true);
        entity.setRole(UserRole.USER);
        entity.setStatus(UserStatus.ACTIVE);
        userRepository.save(entity);
        return null;
    }

    public UserResponseDTO getById(String id) {
        return toResponseDTO(userRepository.findById(id).orElseThrow(() -> {
            throw new ItemNotFoundException("Item not found !");
        }));
    }

    private UserEntity getEntityById(String id) {
        return userRepository.findById(id).orElseThrow(() -> {
            throw new ItemNotFoundException("Item not found !");
        });
    }


    public Boolean update(UserRequestDTO dto, String id) {
        UserEntity entity = getEntityById(id);
        saveEntity(dto, entity);
        return true;
    }

    public Boolean delete(String id, String pId) {
        userRepository.updateVisible(id, false);
        return true;
    }

    public Boolean updateUserRole(String id, UserRole role) {
        userRepository.updateUserRole(id, role);
        return true;
    }
}
