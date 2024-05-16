package com.bovintech.versionone.domain.util;

import lombok.Getter;

@Getter
public class GlobalExeception extends RuntimeException{
    private final String detailsMessage;
    private final String code;
    public GlobalExeception(ErrorCode error) {
        this.detailsMessage = error.getMessage();
        this.code = error.getCode();
    }
}
