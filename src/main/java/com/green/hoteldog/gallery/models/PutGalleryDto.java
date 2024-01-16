package com.green.hoteldog.gallery.models;

import lombok.Data;

import java.util.List;

@Data
public class PutGalleryDto {
    private int userPk;
    private int galleryPk;
    private int galleryCategoryPk;
    private String title;
    private String contents;
    private List<String> pisc;
}
