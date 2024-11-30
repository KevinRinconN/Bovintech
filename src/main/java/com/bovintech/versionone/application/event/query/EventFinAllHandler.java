package com.bovintech.versionone.application.event.query;

import com.bovintech.versionone.domain.event.model.dto.EventGetSearchParamsDto;
import com.bovintech.versionone.domain.event.model.dto.EventToShowDto;
import com.bovintech.versionone.domain.event.model.dto.MonthlyEventsDTO;
import com.bovintech.versionone.domain.event.services.EventFinAllService;
import com.bovintech.versionone.infrastructure.util.ResponseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EventFinAllHandler {
    private final EventFinAllService eventFinAllService;

    public List<MonthlyEventsDTO> execute (EventGetSearchParamsDto searchParamsDto){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String username =  authentication.getName();
            if (authentication.getAuthorities().stream()
                    .noneMatch(authority -> authority.getAuthority().equals("ROLE_ADMIN"))) {
                searchParamsDto.setOperator(true);
            }
            return eventFinAllService.execute(username, searchParamsDto);
        }
        throw new RuntimeException("No user is authenticated");
    }
}
