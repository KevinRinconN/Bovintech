package com.bovintech.versionone.application.record.query;

import com.bovintech.versionone.domain.record.model.dto.MaxWeightPerMonthDto;
import com.bovintech.versionone.domain.record.services.RecordGetPerMonthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RecordGetPerMonthHandler {
    private final RecordGetPerMonthService recordGetPerMonthService;

    public List<MaxWeightPerMonthDto> execute (Long id){
        return recordGetPerMonthService.execute(id);
    }
}
