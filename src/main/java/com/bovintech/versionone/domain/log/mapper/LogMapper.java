package com.bovintech.versionone.domain.log.mapper;

import com.bovintech.versionone.domain.log.model.dto.LogDto;
import com.bovintech.versionone.domain.log.model.dto.LogGetDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
@Component
public interface LogMapper {
    LogMapper INSTANCE = Mappers.getMapper( LogMapper.class );

    LogGetDto toShow (LogDto dto);
}
