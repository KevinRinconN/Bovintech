package com.bovintech.versionone.domain.event.model.exception;

import lombok.Getter;

@Getter
public class EventNotFoundException extends RuntimeException {
  private final String errorMessage = "Evento no encontrado";
    public EventNotFoundException(String message) {
        super(message);
    }
}
