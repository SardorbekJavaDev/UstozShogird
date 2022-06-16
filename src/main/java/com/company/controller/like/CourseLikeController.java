package com.company.controller.like;

import com.company.dto.request.CommentCourseLikeRequestDTO;
import com.company.dto.request.CourseLikeRequestDTO;
import com.company.dto.response.CommentCourseLikeResponseDTO;
import com.company.dto.response.CourseLikeResponseDTO;
import com.company.service.like.CommentCourseLikeService;
import com.company.service.like.CourseLikeService;
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
@RequestMapping("/api/v1/course/ld")
@Slf4j
@Api("Course")
public class CourseLikeController {
    private final CourseLikeService courseLikeService;

    @ApiOperation(value = "Create course like", notes = "Method used for Create course like")
    @PostMapping("")
    public ResponseEntity<CourseLikeResponseDTO> create(@RequestBody @Valid CourseLikeRequestDTO dto,
                                                        HttpServletRequest request) {
        String id = JwtUtil.getIdFromHeader(request);
        System.out.println(id);
        log.info("course like Create {}{}", dto, CommentCourseLikeController.class);
        return ResponseEntity.ok(courseLikeService.create(dto, id));
    }


    @ApiOperation(value = "update course like", notes = "Method used for update course like by id")
    @PutMapping("/{id}")
    public ResponseEntity<Boolean> update(@PathVariable("id") String id,
                                          @RequestBody @Valid CourseLikeRequestDTO dto,
                                          HttpServletRequest request) {
        String pId = JwtUtil.getIdFromHeader(request);
        log.info("course like update {}{}", dto, CommentCourseLikeController.class);
        return ResponseEntity.ok(courseLikeService.update(dto, pId, id));
    }


    @ApiOperation(value = "delete by id course like", notes = "Method used for delete course like by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") String id,
                                          HttpServletRequest request) {
        String pId = JwtUtil.getIdFromHeader(request);
        log.info("Post like delete {}{}", id, CommentCourseLikeController.class);
        return ResponseEntity.ok(courseLikeService.delete(id, pId));
    }





}
