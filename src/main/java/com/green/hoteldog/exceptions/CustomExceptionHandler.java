package com.green.hoteldog.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice // 전역에 발생할 수 있는 예외를 처리해줌
@Slf4j
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    //모든 예외를 처리하는 메소드
    //Bean 내에서 발생하는 예외를 처리
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex){
        log.error("Exception",ex);
        return handleExceptionInternal(CommonErrorCode.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> productException(CustomException t){
        ErrorCode errorCode = t.getErrorCode();
        log.error("{}",errorCode);
        return handleExceptionInternal(errorCode);
    }
    private ResponseEntity<Object> handleExceptionInternal(ErrorCode errorCode){
        return ResponseEntity.status(errorCode.getHttpStatus())
                .body(makeErrorResponse(errorCode));
    }

    private CustomResponse makeErrorResponse(ErrorCode errorCode){
        return CustomResponse.builder()
                .code(errorCode.name())
                .message(errorCode.getMessage())
                .codeNum(errorCode.getErrorNum())
                .build();
    }




}
