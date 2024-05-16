package com.bovintech.versionone.domain.util;

import java.util.HashMap;
import java.util.Map;

public class ExceptionControl {
    private final Map<String, ErrorCode> errorMessages = new HashMap<>();

    public ExceptionControl (Enum<? extends ErrorCode>[] errorCode) {
        for (Enum enumValue : errorCode) {
            ErrorCode error = (ErrorCode) enumValue;
            errorMessages.put(error.getCode(), error);
        }
    }


    public String getErrorMessage(String errorCode) {
        ErrorCode errorMessage = this.errorMessages.get(errorCode);
        return errorMessage != null ? errorMessage.getMessage() : "Error desconocido";
    }
}
