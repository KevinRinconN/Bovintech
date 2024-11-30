package com.bovintech.versionone.infrastructure.auth.adapter.mapper;

import com.bovintech.versionone.infrastructure.auth.adapter.model.entity.UserEntity;
import com.bovintech.versionone.infrastructure.auth.adapter.model.response.UserRest;
import com.bovintech.versionone.infrastructure.cattle.adapter.mapper.CattleDboMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
@Component
public interface UserMapper {

    UserRest toShow (UserEntity entity);

    UserEntity toDbo (UserRest show);
}
