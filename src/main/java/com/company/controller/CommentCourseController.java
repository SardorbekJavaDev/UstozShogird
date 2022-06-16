package com.company.controller;

import com.company.controller.like.CommentCourseLikeController;
import com.company.dto.request.CommentCourseLikeRequestDTO;
import com.company.dto.request.CommentCourseRequestDTO;
import com.company.dto.response.CommentCourseLikeResponseDTO;
import com.company.dto.response.CommentCourseResponseDTO;
import com.company.service.CommentCourseService;
import com.company.service.like.CommentCourseLikeService;
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
@RequestMapping("/api/v1/comment/course")
@Slf4j
@Api("CommentCourse")
public class CommentCourseController {
    private final CommentCourseService commentCourseService;

    @ApiOperation(value = "Create Comment Course", notes = "Method used for Create Comment Course")
    @PostMapping("")
    public ResponseEntity<CommentCourseResponseDTO> create(@RequestBody @Valid CommentCourseRequestDTO dto,
                                                               HttpServletRequest request) {
        String id = JwtUtil.getIdFromHeader(request);
        System.out.println(id);
        log.info("Comment Course Create {}{}", dto, CommentCourseController.class);
        return ResponseEntity.ok(commentCourseService.create(dto, id));
    }


    @ApiOperation(value = "update Comment Course", notes = "Method used for update Comment Course by id")
    @PutMapping("/{id}")
    public ResponseEntity<Boolean> update(@PathVariable("id") String id,
                                          @RequestBody @Valid CommentCourseRequestDTO dto,
                                          HttpServletRequest request) {
        String pId = JwtUtil.getIdFromHeader(request);
        log.info("Comment Course update {}{}", dto, CommentCourseLikeController.class);
        return ResponseEntity.ok(commentCourseService.update(dto, pId, id));
    }


    @ApiOperation(value = "delete by id Comment Course", notes = "Method used for delete Comment Course by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") String id,
                                          HttpServletRequest request) {
        String pId = JwtUtil.getIdFromHeader(request);
        log.info("Comment Course delete {}{}", id, CommentCourseLikeController.class);
        return ResponseEntity.ok(commentCourseService.delete(id, pId));
    }


//    @ApiOperation(value = "Get by id", notes = "Method used for Get Comment Course by id")
//    @GetMapping("/{id}")
//    public ResponseEntity<CommentCourseResponseDTO> getById(@PathVariable("id") String id) {
//        log.info("Comment Course get by id {}{}", id, CommentCourseLikeController.class);
//        return ResponseEntity.ok(commentCourseService.getById(id));
//    }
}
