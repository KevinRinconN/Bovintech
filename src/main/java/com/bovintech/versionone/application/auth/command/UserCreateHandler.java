package com.bovintech.versionone.application.auth.command;

import com.bovintech.versionone.application.auth.mapper.UserRestMapper;
import com.bovintech.versionone.domain.auth.model.dto.request.SignUpRequest;
import com.bovintech.versionone.domain.auth.service.UserCreateService;
import com.bovintech.versionone.infrastructure.auth.adapter.model.response.UserRest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserCreateHandler {
    private final UserCreateService userCreateService;
    private final UserRestMapper userRestMapper;

    public UserRest execute (SignUpRequest signUpRequest){
        return userRestMapper.toRest(userCreateService.execute(signUpRequest));
    }
}
