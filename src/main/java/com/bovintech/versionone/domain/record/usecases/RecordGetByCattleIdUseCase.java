package com.bovintech.versionone.domain.cattle.usecases;

import com.bovintech.versionone.domain.cattle.model.dto.Cattle;
import com.bovintech.versionone.domain.record.model.dto.Record;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class RecordGetByCattleIdUseCase {
    private final CattleGetByIdUseCase cattleGetByIdUseCase;

    public List<Record> execute (Long id){
        Cattle cattle = cattleGetByIdUseCase.execute(id);
        return cattle.getRecords();
    }
}
