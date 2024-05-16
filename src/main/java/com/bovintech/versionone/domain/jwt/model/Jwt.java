package com.bovintech.versionone.domain.jwt.model;

import com.auth0.jwt.algorithms.Algorithm;
import lombok.Getter;

public class Jwt {
    private static final String SECRET_KEY = "secret_key";
    @Getter
    private static Algorithm ALGORITHM = Algorithm.HMAC256(SECRET_KEY);

}
