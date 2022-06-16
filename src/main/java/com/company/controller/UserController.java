package com.company.controller;

import com.company.dto.request.UserRequestDTO;
import com.company.dto.response.UserResponseDTO;
import com.company.enums.UserRole;
import com.company.service.UserService;
import com.company.util.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
@Slf4j
@Api("User")
public class UserController {
    private final UserService userService;

    @ApiOperation(value = "Create User", notes = "Method used for Create User")
    @PostMapping("")
    public ResponseEntity<UserResponseDTO> create(@RequestBody @Valid UserRequestDTO dto) {
        log.info("User Create {}{}", dto, UserController.class);
        return ResponseEntity.ok(userService.create(dto));
    }


    @ApiOperation(value = "update User", notes = "Method used for update User by id")
    @PutMapping("/")
    public ResponseEntity<Boolean> update(@RequestBody @Valid UserRequestDTO dto,
                                          HttpServletRequest request) {
        String id = JwtUtil.getIdFromHeader(request);
        log.info("User update {}{}", dto, UserController.class);
        return ResponseEntity.ok(userService.update(dto, id));
    }


    @ApiOperation(value = "update User role for Admin", notes = "Method used for update User role by id only for Admin")
    @PutMapping("add/admin/{id}")
    public ResponseEntity<Boolean> updateUserRoleAdmin(@PathVariable("id") String uId,
                                                       HttpServletRequest request) {
        String id = JwtUtil.getIdFromHeader(request);
        log.info("User update {}{}", id, UserController.class);
        return ResponseEntity.ok(userService.updateUserRole(uId, UserRole.ADMIN));
    }

    @ApiOperation(value = "update User role for Admin", notes = "Method used for update User role by id only for Admin")
    @PutMapping("add/moderator/{id}")
    public ResponseEntity<Boolean> updateUserRoleModerator(@PathVariable("id") String uId,
                                                           HttpServletRequest request) {
        String id = JwtUtil.getIdFromHeader(request);
        log.info("User update {}{}", id, UserController.class);
        return ResponseEntity.ok(userService.updateUserRole(uId, UserRole.MODERATOR));
    }


    @ApiOperation(value = "delete by id User", notes = "Method used for delete User by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") String id,
                                          HttpServletRequest request) {
        String pId = JwtUtil.getIdFromHeader(request);   // only admin
        log.info("User delete {}{}", id, UserController.class);
        return ResponseEntity.ok(userService.delete(id, pId));
    }


    @ApiOperation(value = "Get User by id", notes = "Method used for Get User by id")
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getById(@PathVariable("id") String id) {
        log.info("User get by id {}{}", id, UserController.class);
        return ResponseEntity.ok(userService.getById(id));
    }


//    @ApiOperation(value = "Get User List", notes = "Method used Get category list with food List by filial id")
//    @GetMapping("/{lang}")
//    public ResponseEntity<List<UserResponseDTO>> getUserList(@PathVariable("lang") LangEnum lang,
//                                                                     @RequestBody GetFilialDTO dto) {
//        return ResponseEntity.ok(userService.getUserList(dto.getFilialId(), lang));
//    }


}
