package com.bovintech.versionone.domain.auth.service;

import com.bovintech.versionone.domain.auth.model.dto.request.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;


@RequiredArgsConstructor
public class UserAuthenticateService {

    private final JwtGenerateService jwtGenerateService;
    private final AuthenticationManager authenticationManager;

    public String execute(LoginRequest loginDto) {
        UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(loginDto.getUsername(),
                loginDto.getPassword());

        Authentication authentication = this.authenticationManager.authenticate(login);
        return this.jwtGenerateService.execute(authentication.getName());
    }
}
