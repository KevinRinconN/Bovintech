package com.bovintech.versionone.application.log.bean;

import com.bovintech.versionone.domain.auth.usecases.UserGetByIdUseCase;
import com.bovintech.versionone.domain.log.port.repository.LogRepository;
import com.bovintech.versionone.domain.log.services.LogGetAllService;
import com.bovintech.versionone.domain.log.useCases.LogGetAllUseCase;
import com.bovintech.versionone.domain.log.useCases.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class logConfig {

    @Bean
    public Logger logger (LogRepository logRepository, UserGetByIdUseCase userGetByIdUseCase){
        return new Logger(logRepository, userGetByIdUseCase);
    }

    @Bean
    public LogGetAllUseCase logGetAllUseCase (LogRepository logRepository){
        return new LogGetAllUseCase(logRepository);
    }

    @Bean
    public LogGetAllService logGetAllService (LogGetAllUseCase logGetAllUseCase){
        return new LogGetAllService(logGetAllUseCase);
    }
}
