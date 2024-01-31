package com.green.hoteldog.user.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserUpdateDto {
    @JsonIgnore
    private int userPk;
    @Schema(description = "유저 닉네임")
    private String nickname;
    @Schema(description = "유저 전화번호")
    private String phoneNum;
    @JsonIgnore
    private String userAddress;
    @Schema(description = "유저 주소 정보")
    private UserAddressEntity addressEntity;
}
