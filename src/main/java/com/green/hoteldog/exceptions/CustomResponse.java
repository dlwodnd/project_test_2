package com.green.hoteldog.exceptions;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class CustomResponse {
    private final String codeNum;
    private final String code;
    private final LocalDateTime errorTimeStamp = LocalDateTime.now();
    private final String message;
}
