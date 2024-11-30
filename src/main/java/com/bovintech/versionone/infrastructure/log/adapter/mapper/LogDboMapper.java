package com.bovintech.versionone.infrastructure.log.adapter.mapper;

import com.bovintech.versionone.domain.log.model.dto.LogDto;
import com.bovintech.versionone.infrastructure.log.adapter.model.LogEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
@Component
public interface LogDboMapper {
    LogDto toDomain (LogEntity entity);
    LogEntity toDbo (LogDto domain);
}
