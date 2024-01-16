package com.green.hoteldog.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
@Getter
@RequiredArgsConstructor
public enum PrimaryKeyErrorCode implements ErrorCode{
    UNKNOWN_PROUCT_PK(HttpStatus.BAD_REQUEST,"E001","잘못된 productPk값 입니다."),
    UNKNOWN_USER_PK(HttpStatus.BAD_REQUEST,"E002","잘못된 userPk값 입니다."),
    UNKNOWN_CATEGORY_PK(HttpStatus.BAD_REQUEST,"E003","잘못된 categoryPk값 입니다.");

    private final HttpStatus httpStatus;
    private final String errorNum;
    private final String message;
}
