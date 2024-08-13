package com.bovintech.versionone.infrastructure.cattle.adapter.mapper;

import com.bovintech.versionone.domain.cattle.model.dto.Cattle;
import com.bovintech.versionone.infrastructure.cattle.adapter.model.entity.CattleEntity;
import org.mapstruct.*;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
@Component
public interface CattleDboMapper {

    @Mapping(target = "sire", qualifiedByName = "toDomainShallow")
    @Mapping(target = "dam", qualifiedByName = "toDomainShallow")
    @Mapping(target = "offspring", ignore = true)  // Ignorar la lista de descendientes
    Cattle toDomain(CattleEntity entity);

    @InheritInverseConfiguration(name = "toDomain")
    @Mapping(target = "sire", qualifiedByName = "toDboShallow")
    @Mapping(target = "dam", qualifiedByName = "toDboShallow")
    @Mapping(target = "offspring", ignore = true)  // Ignorar la lista de descendientes
    CattleEntity toDbo(Cattle domain);

    @Named("toDomainShallow")
    @Mapping(target = "sire", ignore = true)
    @Mapping(target = "dam", ignore = true)
    @Mapping(target = "offspring", ignore = true)
    Cattle toDomainShallow(CattleEntity entity);

    @Named("toDboShallow")
    @Mapping(target = "sire", ignore = true)
    @Mapping(target = "dam", ignore = true)
    @Mapping(target = "offspring", ignore = true)
    CattleEntity toDboShallow(Cattle domain);



}
