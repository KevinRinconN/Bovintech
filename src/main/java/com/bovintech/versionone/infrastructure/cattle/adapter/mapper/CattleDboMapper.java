package com.bovintech.versionone.infrastructure.cattle.adapter.mapper;

import com.bovintech.versionone.domain.cattle.model.dto.Cattle;
import com.bovintech.versionone.infrastructure.cattle.adapter.model.entity.CattleEntity;
import com.bovintech.versionone.infrastructure.event.adapter.mapper.EventMapperRep;
import com.bovintech.versionone.infrastructure.record.adapter.mapper.RecordMapperRepository;
import org.mapstruct.*;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {
        RecordMapperRepository.class,
        EventMapperRep.class,
})
@Component
public interface CattleDboMapper {

    @Mapping(target = "sire", qualifiedByName = "toDomainShallow")
    @Mapping(target = "dam", qualifiedByName = "toDomainShallow")
    @Mapping(target = "offspring", qualifiedByName = "toDomainShallow")
    @Mapping(target = "offspringDam", qualifiedByName = "toDomainShallow")
    Cattle toDomain(CattleEntity entity);

    @InheritInverseConfiguration(name = "toDomain")
    @Mapping(target = "sire", qualifiedByName = "toDboShallow")
    @Mapping(target = "dam", qualifiedByName = "toDboShallow")
    @Mapping(target = "offspring", qualifiedByName = "toDboShallow")
    @Mapping(target = "offspringDam", qualifiedByName = "toDboShallow")
    CattleEntity toDbo(Cattle domain);

    @Named("toDomainShallow")
    @Mapping(target = "sire", ignore = true)
    @Mapping(target = "dam", ignore = true)
    @Mapping(target = "offspring", ignore = true)
    @Mapping(target = "offspringDam", ignore = true)
    Cattle toDomainShallow(CattleEntity entity);

    @Named("toDboShallow")
    @Mapping(target = "sire", ignore = true)
    @Mapping(target = "dam", ignore = true)
    @Mapping(target = "offspring", ignore = true)
    @Mapping(target = "offspringDam", ignore = true)
    CattleEntity toDboShallow(Cattle domain);



}
