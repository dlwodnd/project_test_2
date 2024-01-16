package com.green.hoteldog.gallery;

import com.green.hoteldog.gallery.models.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GalleryMapper {
    int postGallery(PostGalleryDto dto);
    int postGalleryPics(PostGalleryPicDto dto);
    int delGalleryPics(int galleryPk);
    int putGallery(PutGalleryDto dto);
    int postFav(GalleryFavDto dto);
    int delFav(GalleryFavDto dto);
    int delGallery(DeleteGalleryDto dto);
    int postComment(PostCommentDto dto);
    int delComment(DeleteCommentDto dto);
    List<GetSimpleGalleryVo> getGalleryList(GetGalleryListDto dto);
    GetGalleryInfoVo getGalleryInfo(int galleryPk);
    List<String> selGalleryPics(int galleryPk);
    List<CommentInfoVo> getCommentInfo(GetGalleryCommentsDto dto);
}
