package com.green.hoteldog.gallery;

import com.green.hoteldog.common.ResVo;
import com.green.hoteldog.gallery.models.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/gallery")
public class GalleryController {
    private GalleryService service;

    
    //게시글 리스트
    @GetMapping
    public List<GetSimpleGalleryVo> getGalleryList(GetGalleryListDto dto){
        return service.getGalleryList(dto);
    }
    //게시글 세부내용
    @GetMapping("/view")
    public GetGalleryInfoVo getGalleryDetail (GetGalleryCommentsDto dto) {
        return service.getGalleryInfo(dto);
    }
    //게시글 등록
    @PostMapping
    public ResVo postGallery(@RequestBody PostGalleryDto dto){
        return service.postGallery(dto);
    }
    //게시글 수정
    @PutMapping
    public ResVo putGallery(@RequestBody PutGalleryDto dto){
        return service.putGallery(dto);
    }
    //게시글 좋아요
    @GetMapping("/fav")
    public ResVo patchGallery(GalleryFavDto dto){
        return service.putGalleryFav(dto);
    }
    //게시글 삭제
    @DeleteMapping
    public ResVo deleteGallery(@RequestBody DeleteGalleryDto dto){
        return service.deleteGallery(dto);
    }
    //댓글 작성
    @PostMapping("/comment")
    public ResVo postComment(@RequestBody PostCommentDto dto){
        return service.postComment(dto);
    }
    //댓글 삭제
    @DeleteMapping("/comment")
    public ResVo deleteComment(@RequestBody DeleteCommentDto dto){
        return service.deleteComment(dto);
    }
}
