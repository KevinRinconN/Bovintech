package com.bovintech.versionone.application.user.command;

import com.bovintech.versionone.application.user.mapper.UserRestMapper;
import com.bovintech.versionone.domain.user.model.dto.User;
import com.bovintech.versionone.domain.user.model.dto.request.SignUpRequest;
import com.bovintech.versionone.domain.user.service.UserCreateService;
import com.bovintech.versionone.domain.user.service.UserDetailsService;
import com.bovintech.versionone.infrastructure.user.adapter.model.response.UserRest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDetailsHandler {
    private final UserDetailsService userDetailsService;
    private final UserRestMapper userRestMapper;

    public UserRest execute (String accessToken){
        return userRestMapper.toRest(userDetailsService.execute(accessToken));
    }
}
