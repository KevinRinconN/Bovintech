package com.bovintech.versionone.domain.auth.service;

import com.auth0.jwt.JWT;
import com.bovintech.versionone.domain.auth.model.dto.Jwt;

public class JwtDetailsService {

    public String execute(String jwt){
        return JWT.require(Jwt.getALGORITHM())
                .build()
                .verify(jwt)
                .getSubject();
    }
}
