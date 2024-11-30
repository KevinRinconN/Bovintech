package com.bovintech.versionone.domain.auth.usecases;

import com.bovintech.versionone.domain.auth.model.dto.User;
import com.bovintech.versionone.domain.auth.model.exception.UserNotFoundException;
import com.bovintech.versionone.domain.auth.port.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UserGetByIdUseCase {

    private final UserRepository userRepository;

    public User execute (String username){
        return userRepository.getById(username).orElseThrow(UserNotFoundException::new);
    }

}
