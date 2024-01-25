package com.green.hoteldog.user.models;

import lombok.Data;

import java.util.List;

@Data
public class UserSigninVo {
    private int userPk;
    private int userTypePk;
    private String nickname;
    private String accessToken;
    private String depthName;
    private List<Integer> sizePkList;
}
