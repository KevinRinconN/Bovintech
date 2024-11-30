package com.bovintech.versionone.infrastructure.auth.adapter.mapper;

import com.bovintech.versionone.domain.auth.model.dto.User;
import com.bovintech.versionone.infrastructure.auth.adapter.model.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserDboMapper {
    private final UserMapper userMapper;

    public UserEntity toDbo(User domain){
        if(domain == null){
            return null;
        }
        return UserEntity.builder()
                .username(domain.getUsername())
                .firstName(domain.getFirstName())
                .lastName(domain.getLastName())
                .email(domain.getEmail())
                .password(domain.getPassword())
                .rol(domain.getRol())
                .operators(domain.getOperators() == null
                        ? List.of()
                        : domain.getOperators().stream()
                        .map(userMapper::toDbo)
                        .toList())
                .owner(userMapper.toDbo(domain.getOwner()))
                .build();
    }

    public User toDomain(UserEntity entity){
        if(entity == null){
            return null;
        }

        return User.builder()
                .username(entity.getUsername())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .password(entity.getPassword())
                .email(entity.getEmail())
                .rol(entity.getRol())
                .operators(entity.getOperators() == null
                        ? List.of()
                        : entity.getOperators().stream()
                        .map(userMapper::toShow) // Considera usar un mapper más simple aquí
                        .toList())
                .owner(userMapper.toShow(entity.getOwner()))
                .build();
    }
}
