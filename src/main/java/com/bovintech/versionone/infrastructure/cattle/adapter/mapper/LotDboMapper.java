package com.bovintech.versionone.infrastructure.cattle.adapter.mapper;

import com.bovintech.versionone.domain.cattle.model.dto.LotDto;
import com.bovintech.versionone.infrastructure.cattle.adapter.model.entity.CattleLotEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {
        CattleDboMapper.class
})
@Component
public interface LotDboMapper {

    LotDto toDomain (CattleLotEntity domain);

    CattleLotEntity toDbo (LotDto dto);
}
