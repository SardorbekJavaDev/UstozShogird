package com.company.controller;

import com.company.dto.request.CourseRequestDTO;
import com.company.dto.response.CourseResponseDTO;
import com.company.service.CourseService;
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
@RequestMapping("/api/v1/course")
@Slf4j
@Api("Course")
public class CourseController {
    private final CourseService courseService;

    @ApiOperation(value = "Create  Course", notes = "Method used for Create  Course")
    @PostMapping("")
    public ResponseEntity<CourseResponseDTO> create(@RequestBody @Valid CourseRequestDTO dto,
                                                           HttpServletRequest request) {
        String pId = JwtUtil.getIdFromHeader(request);
        System.out.println(pId);
        log.info(" Course Create {}{}", dto, CourseController.class);
        return ResponseEntity.ok(courseService.create(dto, pId));
    }


    @ApiOperation(value = "update  Course", notes = "Method used for update  Course by id")
    @PutMapping("/{id}")
    public ResponseEntity<Boolean> update(@PathVariable("id") String id,
                                          @RequestBody @Valid CourseRequestDTO dto,
                                          HttpServletRequest request) {
        String pId = JwtUtil.getIdFromHeader(request);
        log.info(" Course update {}{}", dto, CourseController.class);
        return ResponseEntity.ok(courseService.update(dto, pId, id));
    }


    @ApiOperation(value = "delete by id  Course", notes = "Method used for delete  Course by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") String id,
                                          HttpServletRequest request) {
        String pId = JwtUtil.getIdFromHeader(request);
        log.info(" Course delete {}{}", id, CourseController.class);
        return ResponseEntity.ok(courseService.delete(id, pId));
    }


    @ApiOperation(value = "Get by id", notes = "Method used for Get  Course by id")
    @GetMapping("/{id}")
    public ResponseEntity<CourseResponseDTO> getById(@PathVariable("id") String id) {
        log.info(" Course get by id {}{}", id, CourseController.class);
        return ResponseEntity.ok(courseService.getById(id));
    }
}
