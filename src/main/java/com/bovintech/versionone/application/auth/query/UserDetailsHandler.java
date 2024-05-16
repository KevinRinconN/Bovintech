package com.bovintech.versionone.application.auth.query;

import com.bovintech.versionone.application.auth.mapper.UserRestMapper;
import com.bovintech.versionone.domain.auth.service.UserDetailsService;
import com.bovintech.versionone.infrastructure.auth.adapter.model.response.UserRest;
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
