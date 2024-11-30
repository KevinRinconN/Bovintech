package com.bovintech.versionone.infrastructure.auth.adapter.model.response;

import com.bovintech.versionone.domain.auth.model.constant.Rol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class UserRest {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private Rol rol;
}
