package com.green.hoteldog.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
@Getter
@RequiredArgsConstructor
public enum StatusErrorCode implements ErrorCode{
    PRODUCT_NM_EMPTY(HttpStatus.BAD_REQUEST,"E201","productNm은 필수 입력값 입니다."),
    ALREADY_CONFIRMED_PRODUCT_PK(HttpStatus.BAD_REQUEST,"E202","이미 구매 확정된 productPk값 입니다.");

    private final HttpStatus httpStatus;
    private final String errorNum;
    private final String message;
}
