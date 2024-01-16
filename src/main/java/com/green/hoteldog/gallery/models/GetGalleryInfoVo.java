package com.green.hoteldog.gallery.models;

import lombok.Data;

import java.lang.reflect.Parameter;
import java.util.List;

@Data
public class GetGalleryInfoVo {
    private int galleryPk;
    private String title;
    private int userPk;
    private String nickname;
    private int favCount;
    private String createdAt;
    private List<String> pics;
    private List<CommentInfoVo> comments;
}
