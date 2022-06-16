package com.company.controller;

import com.company.dto.request.PostRequestDTO;
import com.company.dto.response.PostResponseDTO;
import com.company.service.PostService;
import com.company.util.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
@Slf4j
@Api("Post")
public class PostController {
    private final PostService postService;

    @ApiOperation(value = "Create Post", notes = "Method used for Create Post")
    @PostMapping("")
    public ResponseEntity<PostResponseDTO> create(@RequestBody @Valid PostRequestDTO dto,
                                                  HttpServletRequest request) {
        String id = JwtUtil.getIdFromHeader(request);
        System.out.println(id);
        log.info("Post Create {}{}", dto, PostController.class);
        return ResponseEntity.ok(postService.create(dto, id));
    }


    @ApiOperation(value = "update Post", notes = "Method used for update Post by id")
    @PutMapping("/{id}")
    public ResponseEntity<Boolean> update(@PathVariable("id") String cId,
                                          @RequestBody @Valid PostRequestDTO dto,
                                          HttpServletRequest request) {
        String id = JwtUtil.getIdFromHeader(request);
        log.info("Post update {}{}", dto, PostController.class);
        return ResponseEntity.ok(postService.update(dto, id, cId));
    }


    @ApiOperation(value = "delete by id Post", notes = "Method used for delete Post by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") String id,
                                          HttpServletRequest request) {
        String pId = JwtUtil.getIdFromHeader(request);
        log.info("Post delete {}{}", id, PostController.class);
        return ResponseEntity.ok(postService.delete(id, pId));
    }


    @ApiOperation(value = "Get by id", notes = "Method used for Get category by id")
    @GetMapping("/{id}")
    public ResponseEntity<PostResponseDTO> getById(@PathVariable("id") String id) {
        log.info("Post get by id {}{}", id, PostController.class);
        return ResponseEntity.ok(postService.getById(id));
    }


//    @ApiOperation(value = "Get Post List", notes = "Method used Get category list with food List by filial id")
//    @GetMapping("/{lang}")
//    public ResponseEntity<List<PostResponseDTO>> getPostList(@PathVariable("lang") LangEnum lang,
//                                                                     @RequestBody GetFilialDTO dto) {
//        return ResponseEntity.ok(postService.getPostList(dto.getFilialId(), lang));
//    }


}
