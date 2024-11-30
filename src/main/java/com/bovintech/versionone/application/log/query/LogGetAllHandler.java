package com.bovintech.versionone.application.log.query;

import com.bovintech.versionone.domain.log.model.dto.LogGetDto;
import com.bovintech.versionone.domain.log.model.dto.LogSearchParams;
import com.bovintech.versionone.domain.log.services.LogGetAllService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LogGetAllHandler {
    private final LogGetAllService logGetAllService;

    public Page<LogGetDto> execute (LogSearchParams logSearchParams){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String username =  authentication.getName();
            return logGetAllService.execute(username, logSearchParams);
        }
        throw new RuntimeException("No user is authenticated");
    }
}
