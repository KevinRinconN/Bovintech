package com.bovintech.versionone.infrastructure.beanconfiguration;

import com.bovintech.versionone.domain.auth.service.JwtDetailsService;
import com.bovintech.versionone.domain.auth.service.JwtGenerateService;
import com.bovintech.versionone.domain.auth.service.JwtValidateService;
import com.bovintech.versionone.domain.user.port.repository.UserRepository;
import com.bovintech.versionone.domain.user.service.UserAuthenticateService;
import com.bovintech.versionone.domain.user.service.UserCreateService;
import com.bovintech.versionone.domain.user.service.UserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;

@Configuration
public class AuthBean {
    @Bean
    public UserCreateService userCreateService(UserRepository userRepository){
        return new UserCreateService(userRepository);
    }
    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository, JwtDetailsService jwtDetailsService){
        return new UserDetailsService(userRepository, jwtDetailsService);
    }

    @Bean
    public UserAuthenticateService userAuthenticateService(JwtGenerateService JwtGenerateService, AuthenticationManager authenticationManager){
        return new UserAuthenticateService(JwtGenerateService, authenticationManager);
    }

    @Bean
    public JwtDetailsService jwtDetailsService(){
        return new JwtDetailsService();
    }

    @Bean
    public JwtValidateService jwtValidateService(){
        return new JwtValidateService();
    }

    @Bean
    public JwtGenerateService jwtGenerateService(){
        return new JwtGenerateService();
    }
}
