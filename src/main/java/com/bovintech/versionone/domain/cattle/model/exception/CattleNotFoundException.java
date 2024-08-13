package com.bovintech.versionone.domain.cattle.model.exception;

import com.bovintech.versionone.domain.util.ErrorCode;
import com.bovintech.versionone.domain.util.GlobalExeception;
import lombok.Getter;

@Getter
public class CattleNotFoundException extends GlobalExeception {
    private final String errorMessage = "Bovino no encontrado";
    public CattleNotFoundException(ErrorCode error) {
        super(error);
    }
}
