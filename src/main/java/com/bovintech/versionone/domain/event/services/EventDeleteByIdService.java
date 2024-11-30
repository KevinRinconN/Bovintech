package com.bovintech.versionone.domain.event.services;

import com.bovintech.versionone.domain.event.usecases.EventDeleteByIdUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EventDeleteByIdService {
    private final EventDeleteByIdUseCase eventDeleteByIdUseCase;

    public void execute (Long id){
        eventDeleteByIdUseCase.execute(id);
    }
}
