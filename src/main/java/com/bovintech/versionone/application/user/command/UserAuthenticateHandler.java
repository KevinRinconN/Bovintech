package com.bovintech.versionone.application.user.command;

import com.bovintech.versionone.domain.user.model.dto.request.LoginRequest;
import com.bovintech.versionone.domain.user.service.UserAuthenticateService;
import com.bovintech.versionone.infrastructure.user.adapter.model.response.AuthRest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserAuthenticateHandler {

    private final UserAuthenticateService userAuthenticateService;

    public AuthRest execute (LoginRequest loginRequest){
        return new AuthRest(userAuthenticateService.execute(loginRequest));
    }
}
