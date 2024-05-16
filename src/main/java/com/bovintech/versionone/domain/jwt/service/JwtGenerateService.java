package com.bovintech.versionone.domain.jwt.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.bovintech.versionone.domain.jwt.model.Jwt;

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
