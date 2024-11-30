package com.bovintech.versionone.infrastructure.record.adapter.mapper;

import com.bovintech.versionone.domain.record.model.dto.Record;
import com.bovintech.versionone.infrastructure.record.adapter.model.RecordEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
@Component
public interface RecordMapperRepository {

    Record toDomain (RecordEntity entity);

    RecordEntity toDbo (Record domain);
}
