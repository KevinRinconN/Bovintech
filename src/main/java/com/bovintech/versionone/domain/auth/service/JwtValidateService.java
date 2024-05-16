package com.bovintech.versionone.domain.auth.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.bovintech.versionone.domain.auth.model.dto.Jwt;

public class JwtValidateService {
    public boolean execute (String jwt){
        try {
            JWT.require(Jwt.getALGORITHM())
                    .build()
                    .verify(jwt);
            return true;
        }catch (JWTVerificationException e){
            return false;
        }
    }
}
