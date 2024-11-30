package com.bovintech.versionone.infrastructure.cattle.adapter.jpa;

import com.bovintech.versionone.infrastructure.auth.adapter.model.entity.UserEntity;
import com.bovintech.versionone.infrastructure.cattle.adapter.model.entity.CattleLotEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ILotJpaRepository extends JpaRepository<CattleLotEntity, Long> {
    Page<CattleLotEntity> findByOwnerUsername(String ownerId, Pageable pageable);
    List<CattleLotEntity> findByOwnerUsername(String ownerId);
    Page<CattleLotEntity> findByOperatorUsername(String ownerId, Pageable pageable);
    List<CattleLotEntity> findByOperatorUsername(String ownerId);
    @Query("SELECT DISTINCT lot.operator FROM CattleLotEntity lot WHERE lot.owner.username = :ownerUsername")
    List<UserEntity> findOperatorsByOwnerUsername(@Param("ownerUsername") String ownerUsername);
}
