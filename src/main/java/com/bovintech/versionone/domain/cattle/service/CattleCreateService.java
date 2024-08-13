package com.bovintech.versionone.domain.cattle.service;

import com.bovintech.versionone.domain.cattle.model.constant.CattleErrorCatalog;
import com.bovintech.versionone.domain.cattle.model.dto.Cattle;
import com.bovintech.versionone.domain.cattle.model.dto.command.CattleCreateDTO;
import com.bovintech.versionone.domain.cattle.model.exception.CattleBadRequest;
import com.bovintech.versionone.domain.cattle.model.exception.CattleNotFoundException;
import com.bovintech.versionone.domain.cattle.port.repository.ICattleRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CattleCreateService {

    private final ICattleRepository cattleRepository;

    public Cattle execute (CattleCreateDTO cattleCreateDTO){
        Cattle.CattleBuilder newCattle = Cattle.builder();

        newCattle.dateOfBirth(cattleCreateDTO.getDateOfBirth());
        newCattle.distinctiveTrait(cattleCreateDTO.getDistinctiveTrait());
        newCattle.gender(cattleCreateDTO.getGender());
        newCattle.brand(cattleCreateDTO.getBrand());
        newCattle.breed(cattleCreateDTO.getBreed());

        if (cattleCreateDTO.getSireId() != null) {
            Cattle sire = cattleRepository.findById(cattleCreateDTO.getSireId()).orElseThrow(()-> new CattleNotFoundException(CattleErrorCatalog.CATTLE_SIRE_NOT_FOUND));
            if (!"BULL".equalsIgnoreCase(sire.getGender())) {
                throw new CattleBadRequest(CattleErrorCatalog.CATTLE_MUST_BE_SIRE);
            }
            newCattle.sire(sire);
        }

        if (cattleCreateDTO.getDamId() != null) {
            Cattle dam = cattleRepository.findById(cattleCreateDTO.getDamId()).orElseThrow(()-> new CattleNotFoundException(CattleErrorCatalog.CATTLE_DAM_NOT_FOUND));
            if (!"COW".equalsIgnoreCase(dam.getGender())) {
                throw new CattleBadRequest(CattleErrorCatalog.CATTLE_MUST_BE_DAM);
            }
            newCattle.dam(dam);
        }

        return cattleRepository.create(newCattle.build());
    }
}
