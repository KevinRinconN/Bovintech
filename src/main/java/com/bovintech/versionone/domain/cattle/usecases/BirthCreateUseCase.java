package com.bovintech.versionone.domain.cattle.usecases;

import com.bovintech.versionone.domain.cattle.mapper.CattleMapperDomain;
import com.bovintech.versionone.domain.cattle.model.constant.BirthStatus;
import com.bovintech.versionone.domain.cattle.model.constant.CattleErrorCatalog;
import com.bovintech.versionone.domain.cattle.model.dto.Birth.BirthCreateDto;
import com.bovintech.versionone.domain.cattle.model.dto.Birth.BirthDto;
import com.bovintech.versionone.domain.cattle.model.dto.Cattle;
import com.bovintech.versionone.domain.cattle.model.exception.CattleNotFoundException;
import com.bovintech.versionone.domain.cattle.port.repository.IBirthRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class BirthCreateUseCase {

    private final CattleGetByIdDamUseCase cattleGetByIdDamUseCase;
    private final CattleGetByIdSireUseCase cattleGetByIdSireUseCase;
    private final IBirthRepository iBirthRepository;


    public BirthDto execute (Long idDam, BirthCreateDto birthCreateDto){
        Optional<BirthDto> birth = iBirthRepository.findByDamIdAndStatus(idDam, BirthStatus.EN_PROCESO);

        if(!birth.isEmpty()){
            throw  new CattleNotFoundException(CattleErrorCatalog.CATTLE_NO_ONGOING_BIRTH_IN_PROCESS);
        }

        Cattle dam = cattleGetByIdDamUseCase.execute(idDam);
        Cattle sire = cattleGetByIdSireUseCase.execute(birthCreateDto.getIdSire());
        BirthDto birthToSave = BirthDto.builder()
                .dam(CattleMapperDomain.INSTANCE.withOutRelations(dam))
                .sire(CattleMapperDomain.INSTANCE.withOutRelations(sire))
                .status(BirthStatus.EN_PROCESO)
                .inseminationDate(birthCreateDto.getInseminationDate()).build();
        return iBirthRepository.create(birthToSave);
    }
}
