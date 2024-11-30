package com.bovintech.versionone.infrastructure.cattle.adapter.mapper;

import com.bovintech.versionone.domain.cattle.model.dto.Birth.BirthDto;
import com.bovintech.versionone.infrastructure.cattle.adapter.model.entity.BirthEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {
        CattleDboMapper.class
})
@Component
public interface BirthDboMapper {
    BirthDto toDomain (BirthEntity entity);

    BirthEntity toDbo (BirthDto domain);
}
