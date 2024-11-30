package com.bovintech.versionone.domain.event.port.respository;

import com.bovintech.versionone.domain.event.model.dto.EventDto;
import com.bovintech.versionone.domain.event.model.dto.EventGetSearchParamsDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IEventRepository {

    EventDto save (EventDto dto);
    List<EventDto> findAllSearch (String username, EventGetSearchParamsDto searchParamsDto);
    Optional<EventDto> findById(Long id);
    void delete(Long id);
}
