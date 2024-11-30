package com.bovintech.versionone.domain.event.services;

import com.bovintech.versionone.domain.event.mapper.EventMapper;
import com.bovintech.versionone.domain.event.model.dto.EventCreateDto;
import com.bovintech.versionone.domain.event.model.dto.EventToShowDto;
import com.bovintech.versionone.domain.event.usecases.EventCreateUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EventCreateService {

    private final EventCreateUseCase eventCreateUseCase;

    public EventToShowDto execute (String owner, EventCreateDto createDto){
        return EventMapper.INSTANCE.toShow(eventCreateUseCase.execute(owner, createDto));
    }
}
