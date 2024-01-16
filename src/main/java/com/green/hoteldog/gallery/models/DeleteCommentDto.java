package com.green.hoteldog.gallery.models;

import lombok.Data;

@Data
public class DeleteCommentDto {
    private int userPk;
    private int commentPk;
}
