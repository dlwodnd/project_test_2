package com.green.hoteldog.email;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmailResponseVo {
    private String code;
    private String message;
}
