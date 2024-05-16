package com.bovintech.versionone.infrastructure.user.rest.controller;

import com.bovintech.versionone.application.user.command.UserAuthenticateHandler;
import com.bovintech.versionone.application.user.command.UserCreateHandler;
import com.bovintech.versionone.application.user.command.UserDetailsHandler;
import com.bovintech.versionone.domain.user.model.dto.User;
import com.bovintech.versionone.domain.user.model.dto.request.LoginRequest;
import com.bovintech.versionone.domain.user.model.dto.request.SignUpRequest;
import com.bovintech.versionone.infrastructure.user.adapter.model.response.AuthRest;
import com.bovintech.versionone.infrastructure.user.adapter.model.response.UserRest;
import com.bovintech.versionone.infrastructure.util.ResponseHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserCreateHandler userCreateHandler;
    private final UserAuthenticateHandler userAuthenticateHandler;
    private final UserDetailsHandler userDetailsHandler;

    @PostMapping("/sign-up")
    public ResponseEntity<ResponseHandler<UserRest>> create(@RequestBody @Valid SignUpRequest signUpRequest){
        return ResponseHandler.format("User has been successfully created", HttpStatus.CREATED,userCreateHandler.execute(signUpRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseHandler<AuthRest>> login(@RequestBody LoginRequest loginDto) {
        return ResponseHandler.success("Successful Authorization", userAuthenticateHandler.execute(loginDto));
    }

    @GetMapping("/me")
    public ResponseEntity<ResponseHandler<UserRest>> getGreeting (@RequestHeader("Authorization") String token) {
        return ResponseHandler.success("User data successfully", userDetailsHandler.execute(token));
    }

}
