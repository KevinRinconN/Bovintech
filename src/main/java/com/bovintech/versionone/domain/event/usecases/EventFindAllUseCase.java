package com.bovintech.versionone.domain.event.usecases;

import com.bovintech.versionone.domain.event.model.dto.EventDto;
import com.bovintech.versionone.domain.event.model.dto.EventGetSearchParamsDto;
import com.bovintech.versionone.domain.event.port.respository.IEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RequiredArgsConstructor
public class EventFindAllUseCase {
    private final IEventRepository iEventRepository;

    public List<EventDto> execute (String username, EventGetSearchParamsDto searchParamsDto){
        return iEventRepository.findAllSearch(username, searchParamsDto);
    }
}
