package com.bovintech.versionone.domain.event.services;

import com.bovintech.versionone.domain.event.mapper.EventMapper;
import com.bovintech.versionone.domain.event.model.constant.EventStatus;
import com.bovintech.versionone.domain.event.model.dto.EventToShowDto;
import com.bovintech.versionone.domain.event.usecases.EventUpdateStatusUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EventUpdateStatusService {

    private final EventUpdateStatusUseCase eventUpdateStatusUseCase;

    public EventToShowDto execute (Long idEvent, EventStatus eventStatus){
        return EventMapper.INSTANCE.toShow(eventUpdateStatusUseCase.execute(idEvent, eventStatus));
    }
}
