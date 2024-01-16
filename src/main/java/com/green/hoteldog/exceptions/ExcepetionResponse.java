package com.green.hoteldog.exceptions;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class ExcepetionResponse {
    private final LocalDateTime localDate;
    private final String message;
    private final String detail;

}
