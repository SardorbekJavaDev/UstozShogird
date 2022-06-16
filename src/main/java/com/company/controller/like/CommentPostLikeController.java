package com.company.controller.like;

import com.company.controller.PostController;
import com.company.dto.request.CommentCourseLikeRequestDTO;
import com.company.dto.request.CommentPostLikeRequestDTO;
import com.company.dto.response.CommentCourseLikeResponseDTO;
import com.company.dto.response.CommentPostLikeResponseDTO;
import com.company.service.like.CommentCourseLikeService;
import com.company.service.like.CommentPostLikeService;
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
@RequestMapping("/api/v1/comment/post/ld")
@Slf4j
@Api("CommentPost")
public class CommentPostLikeController {
    private final CommentPostLikeService commentPostLikeService;

    @ApiOperation(value = "Create CommentPostLike", notes = "Method used for Create commentPostLike")
    @PostMapping("")
    public ResponseEntity<CommentPostLikeResponseDTO> create(@RequestBody @Valid CommentPostLikeRequestDTO dto,
                                                             HttpServletRequest request) {
        String id = JwtUtil.getIdFromHeader(request);
        System.out.println(id);
        log.info("CommentPostLike Create {}{}", dto, CommentPostLikeController.class);
        return ResponseEntity.ok(commentPostLikeService.create(dto, id));
    }


    @ApiOperation(value = "update CommentPostLike", notes = "Method used for update CommentPostLike by id")
    @PutMapping("/{id}")
    public ResponseEntity<Boolean> update(@PathVariable("id") String id,
                                          @RequestBody @Valid CommentPostLikeRequestDTO dto,
                                          HttpServletRequest request) {
        String pId = JwtUtil.getIdFromHeader(request);
        log.info("CommentPostLike update {}{}", dto, CommentPostLikeController.class);
        return ResponseEntity.ok(commentPostLikeService.update(dto, pId, id));
    }


    @ApiOperation(value = "delete by id CommentPostLike", notes = "Method used for delete CommentPostLike by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") String id,
                                          HttpServletRequest request) {
        String pId = JwtUtil.getIdFromHeader(request);
        log.info("Post delete {}{}", id, CommentPostLikeController.class);
        return ResponseEntity.ok(commentPostLikeService.delete(id, pId));
    }





}
