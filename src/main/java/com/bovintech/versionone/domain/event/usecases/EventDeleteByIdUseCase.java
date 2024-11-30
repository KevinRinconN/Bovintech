package com.bovintech.versionone.domain.event.usecases;

import com.bovintech.versionone.domain.event.port.respository.IEventRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EventDeleteByIdUseCase {

    private final IEventRepository iEventRepository;
    private final EventGetByIdUseCase eventGetByIdUseCase;

    public void execute (Long id){
        eventGetByIdUseCase.execute(id);
        iEventRepository.delete(id);
    }
}
