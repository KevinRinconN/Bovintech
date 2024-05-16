package com.bovintech.versionone.domain.auth.model.constant;

import com.bovintech.versionone.domain.util.ErrorCode;

public enum UserErrorCatalog implements ErrorCode {
    USERNAME_ALREADY_EXISTS("UAE", "El nombre de usuario ya está registrado"),
    EMAIL_ALREADY_EXISTS("EAE", "La dirección de correo electrónico ya está registrada"),
    USER_NOT_FOUND("UNF", "El usuario no fue encontrado");


    private final String code;
    private final String message;

    UserErrorCatalog(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
