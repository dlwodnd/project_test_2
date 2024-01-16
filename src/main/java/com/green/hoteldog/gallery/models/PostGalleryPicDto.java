package com.green.hoteldog.gallery.models;

import lombok.Data;

import java.util.List;

@Data
public class PostGalleryPicDto {
    private int galleryPk;
    private List<String> pics;
}
