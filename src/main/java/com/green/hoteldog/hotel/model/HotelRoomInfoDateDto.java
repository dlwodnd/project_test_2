package com.green.hoteldog.hotel.model;

import lombok.Data;

import java.util.List;

@Data
public class HotelRoomInfoDateDto {
    private int hotelRoomPk;
    private int roomLeftEa;
    private List<String> roomDate;
}
