package com.bovintech.versionone.infrastructure.auth.adapter.mapper;

import com.bovintech.versionone.domain.auth.model.dto.User;
import com.bovintech.versionone.infrastructure.auth.adapter.model.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserDboMapper {

    public UserEntity toDbo(User domain){
        if(domain == null){
            return null;
        }
        return UserEntity.builder()
                .username(domain.getUsername())
                .firstName(domain.getFirstname())
                .lastName(domain.getLastname())
                .email(domain.getEmail())
                .password(domain.getPassword())
                .rol(domain.getRol())
                .build();
    }

    public User toDomain(UserEntity entity){
        if(entity == null){
            return null;
        }

        return User.builder()
                .username(entity.getUsername())
                .firstname(entity.getFirstName())
                .lastname(entity.getLastName())
                .password(entity.getPassword())
                .email(entity.getEmail())
                .rol(entity.getRol())
                .build();
    }
}
