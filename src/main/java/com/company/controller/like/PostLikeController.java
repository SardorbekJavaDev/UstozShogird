package com.company.controller.like;

import com.company.dto.request.CourseLikeRequestDTO;
import com.company.dto.request.PostLikeRequestDTO;
import com.company.dto.response.CourseLikeResponseDTO;
import com.company.dto.response.PostLikeResponseDTO;
import com.company.service.like.CourseLikeService;
import com.company.service.like.PostLikeService;
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
@RequestMapping("/api/v1/post/ld")
@Slf4j
@Api("Post")
public class PostLikeController {
    private final PostLikeService postLikeService;

    @ApiOperation(value = "Create post like", notes = "Method used for Create post like")
    @PostMapping("")
    public ResponseEntity<PostLikeResponseDTO> create(@RequestBody @Valid PostLikeRequestDTO dto,
                                                      HttpServletRequest request) {
        String id = JwtUtil.getIdFromHeader(request);
        System.out.println(id);
        log.info("post like Create {}{}", dto, PostLikeController.class);
        return ResponseEntity.ok(postLikeService.create(dto, id));
    }


    @ApiOperation(value = "update post like", notes = "Method used for update post like by id")
    @PutMapping("/{id}")
    public ResponseEntity<Boolean> update(@PathVariable("id") String id,
                                          @RequestBody @Valid PostLikeRequestDTO dto,
                                          HttpServletRequest request) {
        String pId = JwtUtil.getIdFromHeader(request);
        log.info("post like update {}{}", dto, PostLikeController.class);
        return ResponseEntity.ok(postLikeService.update(dto, pId, id));
    }


    @ApiOperation(value = "delete by id post like", notes = "Method used for delete post like by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") String id,
                                          HttpServletRequest request) {
        String pId = JwtUtil.getIdFromHeader(request);
        log.info("Post like delete {}{}", id, PostLikeController.class);
        return ResponseEntity.ok(postLikeService.delete(id, pId));
    }




}
