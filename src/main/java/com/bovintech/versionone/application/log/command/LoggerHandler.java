package com.bovintech.versionone.application.log.command;

import com.bovintech.versionone.domain.log.model.constant.ActionType;
import com.bovintech.versionone.domain.log.model.constant.ModuleType;
import com.bovintech.versionone.domain.log.useCases.Logger;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoggerHandler {
    private final Logger logger;

    public void info (String message, ModuleType module,  ActionType actionType){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String username =  authentication.getName();
            logger.save(module, actionType, message,username);
            return;
        }
        throw new RuntimeException("No user is authenticated");
    }
}
