package com.bovintech.versionone.domain.auth.service;

import com.auth0.jwt.JWT;
import com.bovintech.versionone.domain.auth.model.dto.Jwt;

import java.util.Date;

public class JwtGenerateService {

    public String execute(String subject){
        return JWT.create()
                .withSubject(subject)
                .withIssuer("bomberos")
                .withIssuedAt(new Date())
                .sign(Jwt.getALGORITHM());
    }


}
