package com.bovintech.versionone.domain.user.model.exception;

import com.bovintech.versionone.domain.user.model.constant.UserErrorCatalog;
import com.bovintech.versionone.domain.util.ErrorCode;
import com.bovintech.versionone.domain.util.ExceptionControl;
import com.bovintech.versionone.domain.util.GlobalExeception;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class UserAlreadyExitsException extends GlobalExeception {

    private final String errorMessage = "El usuario ya existe";

    public UserAlreadyExitsException(ErrorCode error) {
        super(error);
    }
}
