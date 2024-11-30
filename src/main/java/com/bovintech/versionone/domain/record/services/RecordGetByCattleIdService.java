package com.bovintech.versionone.domain.record.services;

import com.bovintech.versionone.domain.record.RecordMapper;
import com.bovintech.versionone.domain.record.model.dto.Record;
import com.bovintech.versionone.domain.record.model.dto.ShowRecordDto;
import com.bovintech.versionone.domain.record.usecases.RecordGetByCattleIdUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class RecordGetByCattleIdService {
    private final RecordGetByCattleIdUseCase recordGetByCattleIdUseCase;

    public List<ShowRecordDto> execute (Long id){
        List<Record> records = recordGetByCattleIdUseCase.execute(id);
        return records.stream().map(RecordMapper.INSTANCE::toShow).collect(Collectors.toList());
    }
}
