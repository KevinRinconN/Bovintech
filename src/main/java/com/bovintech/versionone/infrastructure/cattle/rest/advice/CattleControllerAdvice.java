package com.bovintech.versionone.infrastructure.cattle.rest.advice;

import com.bovintech.versionone.domain.auth.model.exception.UserAlreadyExitsException;
import com.bovintech.versionone.domain.cattle.model.exception.CattleBadRequest;
import com.bovintech.versionone.domain.cattle.model.exception.CattleNotFoundException;
import com.bovintech.versionone.infrastructure.util.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.Collections;

@ControllerAdvice
public class CattleControllerAdvice {
    @ExceptionHandler(CattleNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundCattle(CattleNotFoundException exception, WebRequest webRequest){
        return new ResponseEntity<>(ErrorResponse.builder()
                .code(exception.getCode())
                .message(exception.getErrorMessage())
                .details(Collections.singletonList(exception.getDetailsMessage()))
                .path(webRequest.getDescription(false).replace("uri=",""))
                .timestamp(LocalDateTime.now())
                .build(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CattleBadRequest.class)
    public ResponseEntity<ErrorResponse> handleBadRequestCattle(CattleBadRequest exception, WebRequest webRequest){
        return new ResponseEntity<>(ErrorResponse.builder()
                .code(exception.getCode())
                .message(exception.getErrorMessage())
                .details(Collections.singletonList(exception.getDetailsMessage()))
                .path(webRequest.getDescription(false).replace("uri=",""))
                .timestamp(LocalDateTime.now())
                .build(), HttpStatus.BAD_REQUEST);
    }
}


