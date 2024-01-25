package com.green.hoteldog.hotel.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class HotelRoomRegistrationDto {
    @JsonIgnore
    private int userPk;
    @JsonIgnore
    private int hotelRoomPk;
    private int hotelPk;
    private int sizePk;
    private String hotelRoomNm;
    private int hotelRoomEa;
    private String hotelRoomCost;
    private int maximum;
    private String roomPic;
}
