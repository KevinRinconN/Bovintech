package com.bovintech.versionone.domain.user.service;

import com.bovintech.versionone.domain.user.model.constant.Rol;
import com.bovintech.versionone.domain.user.model.constant.UserErrorCatalog;
import com.bovintech.versionone.domain.user.model.dto.User;
import com.bovintech.versionone.domain.user.model.dto.request.SignUpRequest;
import com.bovintech.versionone.domain.user.model.exception.UserAlreadyExitsException;
import com.bovintech.versionone.domain.user.port.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
public class UserCreateService {

    private final UserRepository userRepository;
    public User execute (SignUpRequest signUpRequest) {
        Optional<User> existingUser = userRepository.getById(signUpRequest.getUsername())
                .or(() -> this.userRepository.getByEmail(signUpRequest.getEmail()));

        if (existingUser.isPresent()) {
            if (Objects.equals(existingUser.get().getUsername(), signUpRequest.getUsername()))
                throw new UserAlreadyExitsException(UserErrorCatalog.USERNAME_ALREADY_EXISTS);
            if (Objects.equals(existingUser.get().getEmail(), signUpRequest.getEmail()))
                throw new UserAlreadyExitsException(UserErrorCatalog.EMAIL_ALREADY_EXISTS);
        }

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        User newUser = User.builder()
                .username(signUpRequest.getUsername())
                .firstname(signUpRequest.getFirstname())
                .lastname(signUpRequest.getLastname())
                .email(signUpRequest.getEmail())
                .password(bCryptPasswordEncoder.encode(signUpRequest.getPassword()))
                .rol(Rol.valueOf(signUpRequest.getRol()))
                .build();

        return userRepository.create(newUser);
    }
}
