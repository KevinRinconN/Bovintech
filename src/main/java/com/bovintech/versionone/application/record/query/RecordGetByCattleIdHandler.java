package com.bovintech.versionone.application.record.query;

import com.bovintech.versionone.domain.record.model.dto.ShowRecordDto;
import com.bovintech.versionone.domain.record.services.RecordGetByCattleIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RecordGetByCattleIdHandler {
    private final RecordGetByCattleIdService recordGetByCattleIdService;

    public List<ShowRecordDto> execute(Long id){
        return recordGetByCattleIdService.execute(id);
    }
}
