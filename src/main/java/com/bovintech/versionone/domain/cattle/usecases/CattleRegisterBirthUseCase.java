package com.bovintech.versionone.domain.cattle.usecases;

import com.bovintech.versionone.domain.cattle.mapper.CattleMapperDomain;
import com.bovintech.versionone.domain.cattle.model.constant.BirthStatus;
import com.bovintech.versionone.domain.cattle.model.dto.Birth.BirthDto;
import com.bovintech.versionone.domain.cattle.model.dto.Cattle;
import com.bovintech.versionone.domain.cattle.model.dto.CattleBirthRecord;
import com.bovintech.versionone.domain.cattle.model.dto.command.CattleCreateDTO;
import com.bovintech.versionone.domain.cattle.port.repository.IBirthRepository;
import com.bovintech.versionone.domain.cattle.service.CattleCreateService;
import com.bovintech.versionone.domain.record.RecordMapper;
import com.bovintech.versionone.domain.record.usecases.CreateRecordUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CattleRegisterBirthUseCase {

    private final BirthGetByIdUseCase birthGetByIdUseCase;
    private final CattleCreateService cattleCreateService;
    private final CreateRecordUseCase createRecordUseCase;
    private final IBirthRepository iBirthRepository;

    public BirthDto execute (Long birthId, CattleBirthRecord cattleBirthRecord) {
        BirthDto birthDto = birthGetByIdUseCase.execute(birthId);

        CattleCreateDTO cattleCreateDTO = CattleMapperDomain.INSTANCE.toCattleCreateDto(cattleBirthRecord);
        cattleCreateDTO.setDamId(birthDto.getDam().getId());
        cattleCreateDTO.setSireId(birthDto.getSire().getId());

        Cattle cattle = cattleCreateService.execute(cattleCreateDTO);
        createRecordUseCase.execute(cattle.getId(), RecordMapper.INSTANCE.toCreateRecordDto(cattleBirthRecord));

        birthDto.setBirthDate(cattleBirthRecord.getDateOfBirth());
        birthDto.setCalf(CattleMapperDomain.INSTANCE.withOutRelations(cattle));
        birthDto.setStatus(BirthStatus.COMPLETADO);
        return iBirthRepository.save(birthDto);
    }
}
