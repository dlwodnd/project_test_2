package com.green.hoteldog.review.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class ReviewInsDto {
    @JsonIgnore
    private int reviewPk;
    @JsonIgnore
    private int userPk;
    private int resPk;
    private String comment;
    private int score;
    private List<String> pics;
}
