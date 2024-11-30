package com.bovintech.versionone.domain.auth.service;

import com.bovintech.versionone.domain.auth.model.dto.User;
import com.bovintech.versionone.domain.auth.model.exception.UserNotFoundException;
import com.bovintech.versionone.domain.auth.port.repository.UserRepository;
import com.bovintech.versionone.domain.cattle.model.constant.CattleErrorCatalog;
import com.bovintech.versionone.domain.cattle.model.exception.CattleNotFoundException;
import com.bovintech.versionone.infrastructure.auth.adapter.model.response.UserRest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserGetOperatorService {
    private final UserRepository userRepository;

    public List<UserRest> execute (String username) {
        User user = userRepository.getById(username).orElseThrow(UserNotFoundException::new);
        return user.getOperators();
    }
}
