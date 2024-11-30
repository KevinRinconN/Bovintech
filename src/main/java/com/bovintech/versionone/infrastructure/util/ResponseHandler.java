package com.bovintech.versionone.infrastructure.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Getter
public class ResponseHandler<T> extends ResponseEntity<Object>{

    public ResponseHandler(Object body, HttpStatus status) {
        super(body, status);
    }

    public static <T> ResponseHandler<T> success(String message, T data) {
        ResponseFormat<T> responseFormat = new ResponseFormat<>(message, HttpStatus.OK.value(), data);
        return new ResponseHandler<>(responseFormat, HttpStatus.OK);
    }
    public static ResponseHandler<Void> success(String message) {
        ResponseFormat<Void> responseFormat = new ResponseFormat<>(message, HttpStatus.OK.value(), null);
        return new ResponseHandler<>(responseFormat, HttpStatus.OK);
    }

    public static ResponseHandler<Void> success(String message,  HttpStatus status) {
        ResponseFormat<Void> responseFormat = new ResponseFormat<>(message, HttpStatus.OK.value(), null);
        return new ResponseHandler<>(responseFormat, status);
    }

    public static <T> ResponseHandler<T> success(String message, T data,  HttpStatus status) {
        ResponseFormat<T> responseFormat = new ResponseFormat<>(message, HttpStatus.OK.value(), data);
        return new ResponseHandler<>(responseFormat, status);
    }

    public static ResponseHandler<ErrorResponse> error(String message, List<String> details, String code, String path) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .code(code)
                .message(message)
                .details(details)
                .path(path)
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseHandler<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
