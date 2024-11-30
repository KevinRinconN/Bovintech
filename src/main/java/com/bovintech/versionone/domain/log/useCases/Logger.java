package com.bovintech.versionone.domain.log.useCases;

import com.bovintech.versionone.domain.auth.model.dto.User;
import com.bovintech.versionone.domain.auth.usecases.UserGetByIdUseCase;
import com.bovintech.versionone.domain.log.model.constant.ActionType;
import com.bovintech.versionone.domain.log.model.constant.ModuleType;
import com.bovintech.versionone.domain.log.model.dto.LogDto;
import com.bovintech.versionone.domain.log.port.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class Logger {

    private final LogRepository logRepository;
    private final UserGetByIdUseCase userGetByIdUseCase;

    public void save (ModuleType module, ActionType action, String message, String username){
        LogDto logToSave = new LogDto();

        User userToSave = userGetByIdUseCase.execute(username);
        logToSave.setLogger(message);
        logToSave.setModule(module);
        logToSave.setAction(action);
        logToSave.setTimestamp(LocalDateTime.now());
        logToSave.setUser(userToSave);

        logRepository.save(logToSave);
    }
}
