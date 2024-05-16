package com.bovintech.versionone.domain.user.model.dto;

import com.bovintech.versionone.domain.user.model.constant.Rol;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class User {
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Rol rol;
    @Builder.Default
    private Boolean locked = false;
    @Builder.Default
    private Boolean disabled = false;
}
