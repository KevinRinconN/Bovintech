package com.bovintech.versionone.domain.cattle.model.constant;

import com.bovintech.versionone.domain.util.ErrorCode;

public enum CattleErrorCatalog implements ErrorCode {
    CATTLE_SIRE_NOT_FOUND("CSNF", "El padre no fue encontrado"),
    CATTLE_DAM_NOT_FOUND("CDNF", "La madre no fue encontrada"),
    CATTLE_MUST_BE_SIRE("CMBS","El padre debería ser macho"),
    CATTLE_MUST_BE_DAM("CMBD", "La madre debería ser hembra");


    private final String code;
    private final String message;

    CattleErrorCatalog(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
