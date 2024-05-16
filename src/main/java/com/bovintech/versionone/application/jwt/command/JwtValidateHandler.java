package com.bovintech.versionone.application.jwt.command;

import com.bovintech.versionone.domain.jwt.service.JwtValidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtValidateHandler {

    private final JwtValidateService jwtValidateService;
    public boolean execute(String jwt){
        return jwtValidateService.execute(jwt);
    }
}
