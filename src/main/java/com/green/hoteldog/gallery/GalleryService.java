package com.green.hoteldog.gallery;

import com.green.hoteldog.common.ResVo;
import com.green.hoteldog.gallery.models.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GalleryService {
    private GalleryMapper mapper;
    //게시글 등록
    public ResVo postGallery(PostGalleryDto dto){
        int post = mapper.postGallery(dto);
        PostGalleryPicDto picsDto = new PostGalleryPicDto();
        picsDto.setGalleryPk(dto.getGalleryPk());
        picsDto.setPics(dto.getPisc());
        int postPics = mapper.postGalleryPics(picsDto);

        if(postPics + post == dto.getPisc().size() + 1){
            return new ResVo(1);
        }
        return new ResVo(0);
    }
    //게시글 등록

    //게시글 수정
    public ResVo putGallery(PutGalleryDto dto){
        int put = mapper.putGallery(dto);
        int delPics = mapper.delGalleryPics(dto.getGalleryPk());
        PostGalleryPicDto picsDto = new PostGalleryPicDto();
        picsDto.setGalleryPk(dto.getGalleryPk());
        picsDto.setPics(dto.getPisc());
        int postPics = mapper.postGalleryPics(picsDto);
        return new ResVo(put);
    }
    //게시글 수정

    //게시글 좋아요
    public ResVo putGalleryFav(GalleryFavDto dto){
        if(mapper.delFav(dto) == 0){
            mapper.postFav(dto);
            return new ResVo(1);
        }
        return new ResVo(2);
    }
    //게시글 좋아요

    //게시글 삭제
    public ResVo deleteGallery(DeleteGalleryDto dto){
        int result = mapper.delGallery(dto);
        return new ResVo(result);
    }
    //게시글 삭제

    //댓글 등록
    public ResVo postComment(PostCommentDto dto){
        int result = mapper.postComment(dto);
        return new ResVo(result);
    }
    //댓글 등록

    //댓글 삭제
    public ResVo deleteComment(DeleteCommentDto dto){
        int result = mapper.delComment(dto);
        return new ResVo(result);
    }
    //댓글 삭제
    //게시글 리스트
    public List<GetSimpleGalleryVo> getGalleryList(GetGalleryListDto dto){
        return mapper.getGalleryList(dto);
    }
    //게시글 리스트
    //게시글 정보
    public GetGalleryInfoVo getGalleryInfo(GetGalleryCommentsDto dto){
        GetGalleryInfoVo vo = mapper.getGalleryInfo(dto.getGalleryPk());
        vo.setPics(mapper.selGalleryPics(dto.getGalleryPk()));
        vo.setComments(mapper.getCommentInfo(dto));
        return vo;
    }
    //게시글 정보
}
