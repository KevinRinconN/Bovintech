package com.bovintech.versionone.domain.event.mapper;

import com.bovintech.versionone.domain.event.model.dto.EventCreateDto;
import com.bovintech.versionone.domain.event.model.dto.EventDto;
import com.bovintech.versionone.domain.event.model.dto.EventToShowDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
@Component
public interface EventMapper {

    EventMapper INSTANCE = Mappers.getMapper( EventMapper.class );

    EventDto createEventDtoToEvent (EventCreateDto eventDto);

    EventToShowDto toShow (EventDto eventDto);
}
