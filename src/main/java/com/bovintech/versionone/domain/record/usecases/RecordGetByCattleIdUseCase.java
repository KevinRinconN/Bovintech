package com.bovintech.versionone.domain.record.usecases;

import com.bovintech.versionone.domain.cattle.model.dto.Cattle;
import com.bovintech.versionone.domain.cattle.usecases.CattleGetByIdUseCase;
import com.bovintech.versionone.domain.record.model.dto.Record;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class RecordGetByCattleIdUseCase {
    private final CattleGetByIdUseCase cattleGetByIdUseCase;

    public List<Record> execute (Long id){
        Cattle cattle = cattleGetByIdUseCase.execute(id);
        List<Record> records = new ArrayList<>(cattle.getRecords()); // Crear una copia para evitar modificar la lista original
        Collections.reverse(records); // Invertir la lista
        return records;
    }
}
