package com.bovintech.versionone.application.event.command;

import com.bovintech.versionone.domain.event.services.EventDeleteByIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventDeleteByIdHandler {
    private final EventDeleteByIdService eventDeleteByIdService;

    public void execute (Long id){
        eventDeleteByIdService.execute(id);
    }
}
