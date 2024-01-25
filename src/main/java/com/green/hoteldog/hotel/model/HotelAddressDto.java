package com.green.hoteldog.hotel.model;

import lombok.Data;

@Data
public class HotelAddressDto {
    private int hotelPk;
    private String addressName;
    private String region1depthName;
    private String region2depthName;
    private String region3depthName;
    private String zoneNo;
    private String x;
    private String y;
    private String detail;
}
