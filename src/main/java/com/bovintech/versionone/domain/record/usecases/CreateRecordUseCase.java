package com.bovintech.versionone.domain.record.usecases;

import com.bovintech.versionone.domain.cattle.mapper.CattleMapperDomain;
import com.bovintech.versionone.domain.cattle.model.dto.Cattle;
import com.bovintech.versionone.domain.cattle.usecases.CattleGetByIdUseCase;
import com.bovintech.versionone.domain.file.usecases.FileUploadUseCase;
import com.bovintech.versionone.domain.record.RecordMapper;
import com.bovintech.versionone.domain.record.model.dto.CreateRecordDto;
import com.bovintech.versionone.domain.record.model.dto.Record;
import com.bovintech.versionone.domain.record.port.repository.IRecordRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateRecordUseCase {

    private final IRecordRepository recordRepository;
    private final CattleGetByIdUseCase cattleGetByIdUseCase;
    private final FileUploadUseCase fileUploadUseCase;

    public Record execute (Long id, CreateRecordDto recordDto){
        Cattle cattle = cattleGetByIdUseCase.execute(id);
        Record recordToSave = RecordMapper.INSTANCE.createRecordDtoToRecord(recordDto);
        recordToSave.setImg(fileUploadUseCase.execute(recordDto.getImg()));
        recordToSave.setCattle(CattleMapperDomain.INSTANCE.withOutRelations(cattle));
        return recordRepository.create(recordToSave);
    }
}
