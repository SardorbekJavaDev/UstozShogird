package com.company.controller;

import com.company.dto.request.CommentPostRequestDTO;
import com.company.dto.response.CommentPostResponseDTO;
import com.company.service.CommentPostService;
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
@RequestMapping("/api/v1/comment/post")
@Slf4j
@Api("CommentPost")
public class CommentPostController {
    private final CommentPostService commentPostService;
// QWERT YUIOP
    @ApiOperation(value = "Create Comment Post", notes = "Method used for Create Comment Post")
    @PostMapping("")
    public ResponseEntity<CommentPostResponseDTO> create(@RequestBody @Valid CommentPostRequestDTO dto,
                                                           HttpServletRequest request) {
        String id = JwtUtil.getIdFromHeader(request);
        System.out.println(id);
        log.info("Comment Post Create {}{}", dto, CommentPostController.class);
        return ResponseEntity.ok(commentPostService.create(dto, id));
    }


    @ApiOperation(value = "update Comment Post", notes = "Method used for update Comment Post by id")
    @PutMapping("/{id}")
    public ResponseEntity<Boolean> update(@PathVariable("id") String id,
                                          @RequestBody @Valid CommentPostRequestDTO dto,
                                          HttpServletRequest request) {
        String pId = JwtUtil.getIdFromHeader(request);
        log.info("Comment Post update {}{}", dto, CommentPostController.class);
        return ResponseEntity.ok(commentPostService.update(dto, pId, id));
    }


    @ApiOperation(value = "delete by id Comment Post", notes = "Method used for delete Comment Post by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") String id,
                                          HttpServletRequest request) {
        String pId = JwtUtil.getIdFromHeader(request);
        log.info("Comment Post delete {}{}", id, CommentPostController.class);
        return ResponseEntity.ok(commentPostService.delete(id, pId));
    }


//    @ApiOperation(value = "Get by id", notes = "Method used for Get Comment Post by id")
//    @GetMapping("/{id}")
//    public ResponseEntity<CommentPostResponseDTO> getById(@PathVariable("id") String id) {
//        log.info("Comment Post get by id {}{}", id, CommentPostController.class);
//        return ResponseEntity.ok(commentPostService.getById(id));
//    }
}
