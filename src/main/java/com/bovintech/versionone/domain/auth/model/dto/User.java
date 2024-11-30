package com.bovintech.versionone.domain.auth.model.dto;

import com.bovintech.versionone.domain.auth.model.constant.Rol;
import com.bovintech.versionone.domain.event.model.dto.EventDto;
import com.bovintech.versionone.infrastructure.auth.adapter.model.entity.UserEntity;
import com.bovintech.versionone.infrastructure.auth.adapter.model.response.UserRest;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class User {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Rol rol;
    @Builder.Default
    private Boolean locked = false;
    @Builder.Default
    private Boolean disabled = false;

    private List<UserRest> operators;

    private List<EventDto> eventsToOperator;

    private List<EventDto> events;

    private UserRest owner;
}
