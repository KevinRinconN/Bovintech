package com.bovintech.versionone.domain.user.model.exception;

import com.bovintech.versionone.domain.user.model.constant.UserErrorCatalog;
import com.bovintech.versionone.domain.util.ExceptionControl;
import com.bovintech.versionone.domain.util.GlobalExeception;

public class UserNotFoundException extends GlobalExeception {
    public UserNotFoundException() {
        super(UserErrorCatalog.USER_NOT_FOUND);
    }
}
