package com.bovintech.versionone.application.auth.query;

import com.bovintech.versionone.domain.auth.service.JwtValidateService;
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
