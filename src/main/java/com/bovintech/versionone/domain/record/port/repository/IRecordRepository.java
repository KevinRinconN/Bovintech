package com.bovintech.versionone.domain.record.port.repository;

import com.bovintech.versionone.domain.record.model.dto.MaxWeightPerMonthDto;
import com.bovintech.versionone.domain.record.model.dto.Record;

import java.util.List;

public interface IRecordRepository {

    Record create(Record record);
    List<MaxWeightPerMonthDto> findMaxWeightByMonth(Long cattleId);
}
