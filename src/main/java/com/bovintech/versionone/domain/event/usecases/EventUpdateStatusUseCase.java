package com.bovintech.versionone.domain.event.usecases;

import com.bovintech.versionone.domain.cattle.model.constant.CattleErrorCatalog;
import com.bovintech.versionone.domain.cattle.model.exception.CattleNotFoundException;
import com.bovintech.versionone.domain.event.model.constant.EventStatus;
import com.bovintech.versionone.domain.event.model.dto.EventDto;
import com.bovintech.versionone.domain.event.model.exception.EventNotFoundException;
import com.bovintech.versionone.domain.event.port.respository.IEventRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EventUpdateStatusUseCase {

    private final IEventRepository iEventRepository;
    private final EventGetByIdUseCase eventGetByIdUseCase;

    public EventDto execute (Long idEvent, EventStatus eventStatus){
        EventDto eventToSave = eventGetByIdUseCase.execute(idEvent);
        eventToSave.setStatus(eventStatus);
        return iEventRepository.save(eventToSave);
    }
}
