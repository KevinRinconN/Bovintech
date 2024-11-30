package com.bovintech.versionone.application.event.command;

import com.bovintech.versionone.domain.event.model.dto.EventCreateDto;
import com.bovintech.versionone.domain.event.model.dto.EventToShowDto;
import com.bovintech.versionone.domain.event.services.EventCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventCreateHandler {
    private final EventCreateService eventCreateService;

    public EventToShowDto execute (EventCreateDto eventCreateDto){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String username =  authentication.getName();
            if (authentication.getAuthorities().stream()
                    .noneMatch(authority -> authority.getAuthority().equals("ROLE_ADMIN"))) {
                eventCreateDto.setOperator(true);
            }
            return eventCreateService.execute(username, eventCreateDto);
        }
        throw new RuntimeException("No user is authenticated");
    }
}
