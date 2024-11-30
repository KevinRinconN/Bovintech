package com.bovintech.versionone.infrastructure.event.adapter.jpa;

import com.bovintech.versionone.infrastructure.event.adapter.model.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IEventJpaRepository extends JpaRepository<EventEntity, Long>, JpaSpecificationExecutor<EventEntity> {
}
