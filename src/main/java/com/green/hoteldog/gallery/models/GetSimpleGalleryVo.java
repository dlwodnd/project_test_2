package com.green.hoteldog.gallery.models;

import lombok.Data;

@Data
public class GetSimpleGalleryVo {
    private int galleryPk;
    private String title;
    private int userPk;
    private String nickname;
    private int commentsCount;
    private int favCount;
    private String createdAt;
}
