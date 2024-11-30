package com.bovintech.versionone.domain.event.usecases;

import com.bovintech.versionone.domain.event.model.dto.EventDto;
import com.bovintech.versionone.domain.event.model.exception.EventNotFoundException;
import com.bovintech.versionone.domain.event.port.respository.IEventRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EventGetByIdUseCase {
    private final IEventRepository iEventRepository;

    public EventDto execute (Long id){
        return iEventRepository.findById(id).orElseThrow(()-> new EventNotFoundException("El evento con el id "+id+" no existe"));
    }
}
