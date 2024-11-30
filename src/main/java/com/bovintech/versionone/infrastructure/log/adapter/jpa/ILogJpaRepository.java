package com.bovintech.versionone.infrastructure.log.adapter.jpa;

import com.bovintech.versionone.infrastructure.event.adapter.model.EventEntity;
import com.bovintech.versionone.infrastructure.log.adapter.model.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ILogJpaRepository extends JpaRepository<LogEntity, Long> , JpaSpecificationExecutor<LogEntity> {
}
