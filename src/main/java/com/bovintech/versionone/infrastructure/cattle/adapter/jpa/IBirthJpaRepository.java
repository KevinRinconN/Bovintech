package com.bovintech.versionone.infrastructure.cattle.adapter.jpa;

import com.bovintech.versionone.domain.cattle.model.constant.BirthStatus;
import com.bovintech.versionone.domain.cattle.model.dto.Birth.BirthDto;
import com.bovintech.versionone.infrastructure.cattle.adapter.model.entity.BirthEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IBirthJpaRepository extends JpaRepository<BirthEntity, Long> {
    Optional<BirthEntity> findByDamIdAndStatus(Long damId, BirthStatus status);
    List<BirthEntity> findByDamIdAndIsAbortion(Long idDam, boolean isAbortion);
    List<BirthEntity> findByDamIdOrderByBirthDateDesc(Long damId);
}