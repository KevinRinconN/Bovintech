package com.bovintech.versionone.application.auth.query;

import com.bovintech.versionone.domain.auth.model.dto.request.LoginRequest;
import com.bovintech.versionone.domain.auth.service.UserAuthenticateService;
import com.bovintech.versionone.infrastructure.auth.adapter.model.response.AccessTokenRest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserAuthenticateHandler {

    private final UserAuthenticateService userAuthenticateService;

    public AccessTokenRest execute (LoginRequest loginRequest){
        return new AccessTokenRest(userAuthenticateService.execute(loginRequest));
    }
}
