package com.bovintech.versionone.application.jwt.command;

import com.bovintech.versionone.domain.jwt.service.JwtDetailsService;
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
