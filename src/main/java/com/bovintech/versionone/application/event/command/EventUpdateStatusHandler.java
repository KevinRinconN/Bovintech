package com.bovintech.versionone.application.event.command;

import com.bovintech.versionone.domain.event.model.constant.EventStatus;
import com.bovintech.versionone.domain.event.model.dto.EventToShowDto;
import com.bovintech.versionone.domain.event.services.EventUpdateStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventUpdateStatusHandler {
    private final EventUpdateStatusService eventUpdateStatusService;

    public EventToShowDto execute (Long id, EventStatus eventStatus){
        return eventUpdateStatusService.execute(id, eventStatus);
    }
}
