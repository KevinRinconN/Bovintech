package com.bovintech.versionone.domain.auth.service;

import com.bovintech.versionone.domain.auth.model.dto.User;
import com.bovintech.versionone.domain.auth.port.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserDetailsService {

    private final UserRepository userRepository;
    private final JwtDetailsService jwtDetailsService;
    public User execute (String token) {
        if (token == null || !token.startsWith("Bearer")) throw new RuntimeException("Invalid access token");

        String jwt = token.split(" ")[1].trim();
        String username = this.jwtDetailsService.execute(jwt);

        return this.userRepository.getById(username).orElseThrow();
    }
}
