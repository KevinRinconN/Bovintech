package com.bovintech.versionone.domain.event.model.exception;

public class EventBadRequest extends RuntimeException {
  public EventBadRequest(String message) {
    super(message);
  }
}
