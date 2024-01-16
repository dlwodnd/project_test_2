package com.green.hoteldog.review.models;

import lombok.Data;

import java.util.List;

@Data
public class HotelReviewSelVo {
    private int reviewPk;
    private int userPk;
    private String nickname;
    private String comment;
    private int score;
    private String createdAt;
    private int favCount;
    private List<String> pics;
}
