package com.bovintech.versionone.infrastructure.cattle.adapter.jpa;

import com.bovintech.versionone.infrastructure.cattle.adapter.model.entity.CattleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ICattleJpaRepository extends JpaRepository<CattleEntity, Long> , JpaSpecificationExecutor<CattleEntity> {
    Page<CattleEntity> findByGender(String gender, Pageable pageable);
    Page<CattleEntity> findBySireIdOrDamId(Long sireId, Long damId, Pageable pageable);

}
