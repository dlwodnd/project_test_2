  package com.green.hoteldog.review.models;

import lombok.Data;

import java.util.List;

@Data
public class ReviewUpdDto {
    private int reviewPk;
    private int userPk;
    private int resPk;
    private String comment;
    private int score;
    private List<String> pics;
}
