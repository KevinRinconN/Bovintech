package com.bovintech.versionone.application.record.command;

import com.bovintech.versionone.domain.record.model.dto.CreateRecordDto;
import com.bovintech.versionone.domain.record.model.dto.ShowRecordDto;
import com.bovintech.versionone.domain.record.services.CreateRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateRecordHandler {
    private final CreateRecordService createRecordService;

    public ShowRecordDto execute (Long id, CreateRecordDto createRecordDto){
        return createRecordService.execute(id, createRecordDto);
    }
}
