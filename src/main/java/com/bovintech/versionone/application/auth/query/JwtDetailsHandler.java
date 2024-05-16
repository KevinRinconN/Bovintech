package com.bovintech.versionone.application.auth.query;

import com.bovintech.versionone.domain.auth.service.JwtDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtDetailsHandler {
    private final JwtDetailsService jwtDetailsService;
    public String execute(String jwt){
        return jwtDetailsService.execute(jwt);
    }
}
