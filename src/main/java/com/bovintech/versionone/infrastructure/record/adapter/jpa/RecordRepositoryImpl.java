package com.bovintech.versionone.infrastructure.record.adapter.jpa;

import com.bovintech.versionone.domain.record.model.dto.MaxWeightPerMonthDto;
import com.bovintech.versionone.domain.record.model.dto.Record;
import com.bovintech.versionone.domain.record.port.repository.IRecordRepository;
import com.bovintech.versionone.infrastructure.record.adapter.mapper.RecordMapperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RecordRepositoryImpl implements IRecordRepository {

    private final IRecordJpaRepository iRecordJpaRepository;
    private final RecordMapperRepository recordMapper;

    @Override
    public Record create(Record record) {
        return recordMapper.toDomain(iRecordJpaRepository.save(recordMapper.toDbo(record)));
    }

    @Override
    public List<MaxWeightPerMonthDto> findMaxWeightByMonth(Long id) {
        return iRecordJpaRepository.findMaxWeightByMonthForCattle(id);
    }
}
