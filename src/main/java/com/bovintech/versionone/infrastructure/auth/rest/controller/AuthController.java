package com.bovintech.versionone.infrastructure.auth.rest.controller;

import com.bovintech.versionone.application.auth.query.UserAuthenticateHandler;
import com.bovintech.versionone.application.auth.command.UserCreateHandler;
import com.bovintech.versionone.application.auth.query.UserDetailsHandler;
import com.bovintech.versionone.domain.auth.model.dto.request.LoginRequest;
import com.bovintech.versionone.domain.auth.model.dto.request.SignUpRequest;
import com.bovintech.versionone.infrastructure.auth.adapter.model.response.AccessTokenRest;
import com.bovintech.versionone.infrastructure.auth.adapter.model.response.UserRest;
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
    public ResponseEntity<ResponseHandler<AccessTokenRest>> login(@RequestBody LoginRequest loginDto) {
        return ResponseHandler.success("Successful Authorization", userAuthenticateHandler.execute(loginDto));
    }

    @GetMapping("/me")
    public ResponseEntity<ResponseHandler<UserRest>> getGreeting (@RequestHeader("Authorization") String token) {
        return ResponseHandler.success("User data successfully", userDetailsHandler.execute(token));
    }

}
