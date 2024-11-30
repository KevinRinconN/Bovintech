package com.bovintech.versionone.domain.record.services;

import com.bovintech.versionone.domain.record.RecordMapper;
import com.bovintech.versionone.domain.record.model.dto.CreateRecordDto;
import com.bovintech.versionone.domain.record.model.dto.ShowRecordDto;
import com.bovintech.versionone.domain.record.usecases.CreateRecordUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateRecordService {
    private final CreateRecordUseCase createRecordUseCase;

    public ShowRecordDto execute (Long id, CreateRecordDto recordDto){
        return RecordMapper.INSTANCE.toShow(createRecordUseCase.execute(id, recordDto));
    }
}
