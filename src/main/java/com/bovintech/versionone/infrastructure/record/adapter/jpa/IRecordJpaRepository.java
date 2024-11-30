package com.bovintech.versionone.infrastructure.record.adapter.jpa;

import com.bovintech.versionone.infrastructure.record.adapter.model.RecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRecordRepository extends JpaRepository<RecordEntity, Long> {
}
