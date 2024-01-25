package com.green.hoteldog.hotel.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class HotelRegistrationDto {
    @JsonIgnore
    private int hotelPk;
    @JsonIgnore
    private int userPk;
    private String hotelNm;
    private String hotelDetailInfo;
    private String businessNum;
    private String hotelCall;

    private List<String> pics;

    private List<Integer> optionPkList;

    private String addressName;
    private String region1depthName;
    private String region2depthName;
    private String region3depthName;
    private String zoneNo;
    private String x;
    private String y;
    private String detail;
}
