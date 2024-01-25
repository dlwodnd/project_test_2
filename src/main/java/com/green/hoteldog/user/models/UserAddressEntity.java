package com.green.hoteldog.user.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class UserAddressEntity {
    @JsonIgnore
    private int userPk;
    private String addressName;
    private String region1depthName;
    private String region2depthName;
    private String region3depthName;
    private String zoneNo;
    private String x;
    private String y;
    private String detail;
}
