package com.bovintech.versionone.application.auth;

import com.bovintech.versionone.domain.auth.port.repository.UserRepository;
import com.bovintech.versionone.domain.auth.usecases.OperatorGetAllByIdUseCase;
import com.bovintech.versionone.domain.auth.usecases.UserGetByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    public OperatorGetAllByIdUseCase operatorGetAllByIdUseCase (UserRepository userRepository){
        return new OperatorGetAllByIdUseCase(userRepository);
    }

    @Bean
    public UserGetByIdUseCase userGetByIdUseCase (UserRepository userRepository){
        return new UserGetByIdUseCase(userRepository);
    }
}
