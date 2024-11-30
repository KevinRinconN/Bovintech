package com.bovintech.versionone.domain.record.services;

import com.bovintech.versionone.domain.record.model.dto.MaxWeightPerMonthDto;
import com.bovintech.versionone.domain.record.port.repository.IRecordRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class RecordGetPerMonthService {
    private final IRecordRepository iRecordRepository;

    public List<MaxWeightPerMonthDto> execute (Long id){
        return iRecordRepository.findMaxWeightByMonth(id);
    }
}
