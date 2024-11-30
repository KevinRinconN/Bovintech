package com.bovintech.versionone.infrastructure.record.adapter.jpa;

import com.bovintech.versionone.domain.record.model.dto.MaxWeightPerMonthDto;
import com.bovintech.versionone.infrastructure.record.adapter.model.RecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IRecordJpaRepository extends JpaRepository<RecordEntity, Long> {

    @Query("SELECT new com.bovintech.versionone.domain.record.model.dto.MaxWeightPerMonthDto(" +
            "FUNCTION('DATE_FORMAT', r.dateOfRecord, '%M'), MAX(r.weight)) " +
            "FROM RecordEntity r " +
            "WHERE r.cattle.id = :cattleId " +
            "GROUP BY FUNCTION('MONTH', r.dateOfRecord), FUNCTION('YEAR', r.dateOfRecord)")
    List<MaxWeightPerMonthDto> findMaxWeightByMonthForCattle(@Param("cattleId") Long cattleId);
}
