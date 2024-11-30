package com.bovintech.versionone.domain.cattle.mapper;

import com.bovintech.versionone.domain.auth.model.dto.User;
import com.bovintech.versionone.domain.cattle.model.dto.*;
import com.bovintech.versionone.infrastructure.auth.adapter.model.response.UserRest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface LotMapperDomain {

    LotMapperDomain INSTANCE = Mappers.getMapper(LotMapperDomain.class);

    @Mapping(target = "numberCattle", expression = "java(getNumberCattle(dto.getCattle()))")
    LotShowDto toLotShow (LotDto dto);

    default Integer getNumberCattle (List<CattleWithOutRelationsDto> cattle){
        return cattle.size();
    }

    @Mapping(target = "owner", ignore = true)
    @Mapping(target = "operator", ignore = true)
    LotDto toDto (LotCreateDto createDto);


    UserRest toUseShow (User user);
}
