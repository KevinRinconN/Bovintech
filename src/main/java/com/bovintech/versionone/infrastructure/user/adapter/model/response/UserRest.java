package com.bovintech.versionone.infrastructure.user.adapter.model.response;

import com.bovintech.versionone.domain.user.model.constant.Rol;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserRest {
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private Rol rol;
}
