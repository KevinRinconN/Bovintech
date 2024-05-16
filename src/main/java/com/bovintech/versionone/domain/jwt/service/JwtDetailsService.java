package com.bovintech.versionone.domain.jwt.service;

import com.auth0.jwt.JWT;
import com.bovintech.versionone.domain.jwt.model.Jwt;

public class JwtDetailsService {

    public String execute(String jwt){
        return JWT.require(Jwt.getALGORITHM())
                .build()
                .verify(jwt)
                .getSubject();
    }
}
