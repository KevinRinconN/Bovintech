package com.bovintech.versionone.domain.event.model.exception;

public class EventNotFoundException extends RuntimeException {
  public EventNotFoundException(String message) {
    super(message);
  }
}
