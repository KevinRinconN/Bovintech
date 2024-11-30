package com.bovintech.versionone.infrastructure.event.rest.advice;

import com.bovintech.versionone.domain.cattle.model.exception.CattleNotFoundException;
import com.bovintech.versionone.domain.event.model.exception.EventBadRequest;
import com.bovintech.versionone.domain.event.model.exception.EventNotFoundException;
import com.bovintech.versionone.infrastructure.util.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.Collections;

@ControllerAdvice
public class EventAdviceController {

    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundEvent(EventNotFoundException exception, WebRequest webRequest){
        return new ResponseEntity<>(ErrorResponse.builder()
                .code("EVENT_NOT_FOUND")
                .message(exception.getErrorMessage())
                .details(Collections.singletonList(exception.getErrorMessage()))
                .path(webRequest.getDescription(false).replace("uri=",""))
                .timestamp(LocalDateTime.now())
                .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EventBadRequest.class)
    public ResponseEntity<ErrorResponse> handleBadEvent(EventBadRequest exception, WebRequest webRequest){
        return new ResponseEntity<>(ErrorResponse.builder()
                .code("EVENT_BAD_REQUEST")
                .message(exception.getErrorMessage())
                .details(Collections.singletonList(exception.getErrorMessage()))
                .path(webRequest.getDescription(false).replace("uri=",""))
                .timestamp(LocalDateTime.now())
                .build(), HttpStatus.NOT_FOUND);
    }
}
