package com.bovintech.versionone.domain.cattle.model.exception;

import com.bovintech.versionone.domain.util.ErrorCode;
import com.bovintech.versionone.domain.util.GlobalExeception;
import lombok.Getter;

@Getter
public class CattleBadRequest extends GlobalExeception {
    private final String errorMessage = "Ups!, Algo salio mal";
    public CattleBadRequest(ErrorCode error) {
        super(error);
    }
}
