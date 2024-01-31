package com.green.hoteldog.user.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserInfoDto {
    @JsonIgnore
    private int userPk;
    @Schema(description = "유저 비밀번호")
    private String upw;
}
