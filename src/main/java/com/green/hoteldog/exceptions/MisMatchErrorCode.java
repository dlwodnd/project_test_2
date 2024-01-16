package com.green.hoteldog.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum MisMatchErrorCode implements ErrorCode {
    MIS_MATCH_USER_PK(HttpStatus.BAD_REQUEST,"E101","입력하신 productPk값은 다른 유저가 작성한 productPk값 입니다.");

    private final HttpStatus httpStatus;
    private final String errorNum;
    private final String message;
}
