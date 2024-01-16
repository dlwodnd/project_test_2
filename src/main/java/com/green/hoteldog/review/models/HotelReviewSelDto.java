package com.green.hoteldog.review.models;

import lombok.Data;

@Data
public class HotelReviewSelDto {
    private int hotelPk;
    private int page;
    private int rowCount;
    private int startIdx;

    public void setPage(int page){
        this.startIdx = (page - 1) * this.rowCount;
    }
}
