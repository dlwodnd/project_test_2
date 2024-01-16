package com.green.hoteldog.gallery.models;

import lombok.Data;

@Data
public class GetGalleryCommentsDto {
    private int galleryPk;
    private int page;
    private int rowCount;

    public void setPage(int page){
        this.rowCount = (page - 1) * this.rowCount;
    }
}
