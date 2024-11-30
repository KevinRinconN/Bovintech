package com.bovintech.versionone.domain.cattle.usecases;

import com.bovintech.versionone.domain.cattle.model.constant.CattleErrorCatalog;
import com.bovintech.versionone.domain.cattle.model.dto.Cattle;
import com.bovintech.versionone.domain.cattle.model.exception.CattleNotFoundException;
import com.bovintech.versionone.domain.cattle.port.repository.ICattleRepository;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RequiredArgsConstructor
public class CattleGetByIdSireUseCase {
    private final ICattleRepository iCattleRepository;

    public Cattle execute (Long id) {
        Cattle cattle =  iCattleRepository.findById(id).orElseThrow(()-> new CattleNotFoundException(CattleErrorCatalog.CATTLE_NOT_FOUND));

        if (Objects.equals(cattle.getGender(), "COW")){
            throw new CattleNotFoundException(CattleErrorCatalog.CATTLE_SIRE_NOT_FOUND);
        }
        return cattle;
    }

}
