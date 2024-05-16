package com.bovintech.versionone.infrastructure.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;


@Getter
@AllArgsConstructor
public class ResponseHandler<T>{
    private  String message;
    private  int status;
    private  T data;

    public static <T> ResponseEntity<ResponseHandler<T>> format(String message, HttpStatus status, T data) {
        return new ResponseEntity<>(new ResponseHandler<>(message, status.value(), data), status);
    }

    public static <T> ResponseEntity<ResponseHandler<T>> success(String message, T data) {
        return ResponseEntity.ok(new ResponseHandler<>(message,HttpStatus.OK.value(),data));
    }


}
