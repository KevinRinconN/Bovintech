package com.bovintech.versionone.infrastructure.user.rest.advice;

import com.bovintech.versionone.domain.user.model.exception.UserAlreadyExitsException;
import com.bovintech.versionone.infrastructure.util.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.Collections;

@ControllerAdvice
public class UserControllerAdvice {

    @ExceptionHandler(UserAlreadyExitsException.class)
    public ResponseEntity<ErrorResponse> handleAlreadyExitsUser(UserAlreadyExitsException userException, WebRequest webRequest){
        return new ResponseEntity<>(ErrorResponse.builder()
                .code(userException.getCode())
                .message(userException.getErrorMessage())
                .details(Collections.singletonList(userException.getDetailsMessage()))
                .path(webRequest.getDescription(false).replace("uri=",""))
                .timestamp(LocalDateTime.now())
                .build(), HttpStatus.BAD_REQUEST);
    }
}
