package com.green.hoteldog.gallery.models;

import lombok.Data;

@Data
public class CommentInfoVo {
    private int commentPk;
    private int userPk;
    private String userNickname;
    private String comments;
    private String createdAt;
}
