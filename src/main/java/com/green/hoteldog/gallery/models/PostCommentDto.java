package com.green.hoteldog.gallery.models;

import lombok.Data;

@Data
public class PostCommentDto {
    private int userPk;
    private int galleryPk;
    private String comments;
}
