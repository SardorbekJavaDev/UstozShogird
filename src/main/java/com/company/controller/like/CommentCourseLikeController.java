package com.company.controller.like;

import com.company.dto.request.CommentCourseLikeRequestDTO;
import com.company.dto.response.CommentCourseLikeResponseDTO;
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
@RequestMapping("/api/v1/comment/course/ld")
@Slf4j
@Api("CommentCourse")
public class CommentCourseLikeController {
    private final CommentCourseLikeService commentCourseLikeService;

    @ApiOperation(value = "Create Comment Course like", notes = "Method used for Create Comment Course like")
    @PostMapping("")
    public ResponseEntity<CommentCourseLikeResponseDTO> create(@RequestBody @Valid CommentCourseLikeRequestDTO dto,
                                                               HttpServletRequest request) {
        String pId = JwtUtil.getIdFromHeader(request);
        System.out.println(pId);
        log.info("Comment Course like Create {}{}", dto, CommentCourseLikeController.class);
        return ResponseEntity.ok(commentCourseLikeService.create(dto, pId));
    }


//    @ApiOperation(value = "update Comment Course like", notes = "Method used for update Comment Course like by id")
//    @PutMapping("/{id}")
//    public ResponseEntity<Boolean> update(@PathVariable("id") String id,
//                                          @RequestBody @Valid CommentCourseLikeRequestDTO dto,
//                                          HttpServletRequest request) {
//        String pId = JwtUtil.getIdFromHeader(request);
//        log.info("Comment Course like update {}{}", dto, CommentCourseLikeController.class);
//        return ResponseEntity.ok(commentCourseLikeService.update(dto, pId, id));
//    }


    @ApiOperation(value = "delete by id Comment Course like", notes = "Method used for delete Comment Course like by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") String id,
                                          HttpServletRequest request) {
        String pId = JwtUtil.getIdFromHeader(request);
        log.info("Comment Course like delete {}{}", id, CommentCourseLikeController.class);
        return ResponseEntity.ok(commentCourseLikeService.delete(id, pId));
    }




}
