package com.bovintech.versionone.infrastructure.user.adapter.jpa;

import com.bovintech.versionone.infrastructure.user.adapter.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository  extends JpaRepository<UserEntity, String> {
    Optional<UserEntity> findByEmail(String email);
}
