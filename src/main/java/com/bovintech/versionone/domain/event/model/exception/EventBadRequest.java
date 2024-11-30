package com.bovintech.versionone.domain.event.model.exception;

import lombok.Getter;

@Getter
public class EventBadRequest extends RuntimeException {
    private final String errorMessage = "Ups!, Algo salio mal";
    public EventBadRequest(String message) {
        super(message);
    }
}
