package com.bovintech.versionone.infrastructure.auth.adapter.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AccessTokenRest {
    @JsonProperty("access_token")
    private String accessToken;
}
