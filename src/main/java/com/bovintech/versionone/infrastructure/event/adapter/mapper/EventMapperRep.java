package com.bovintech.versionone.infrastructure.event.adapter.mapper;

import com.bovintech.versionone.domain.event.model.dto.EventDto;
import com.bovintech.versionone.infrastructure.event.adapter.model.EventEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
@Component
public interface EventMapperRep {
    EventDto toDomain (EventEntity entity);

    EventEntity toDbo (EventDto domain);
}
