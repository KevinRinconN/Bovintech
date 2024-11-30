package com.bovintech.versionone.domain.cattle.usecases;

import com.bovintech.versionone.domain.cattle.model.constant.CattleErrorCatalog;
import com.bovintech.versionone.domain.cattle.model.dto.Cattle;
import com.bovintech.versionone.domain.cattle.model.exception.CattleNotFoundException;
import com.bovintech.versionone.domain.cattle.port.repository.ICattleRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CattleGetByIdUseCase {

    private final ICattleRepository iCattleRepository;

    public Cattle execute (Long id) {
        return iCattleRepository.findById(id).orElseThrow(()-> new CattleNotFoundException(CattleErrorCatalog.CATTLE_NOT_FOUND));
    }

}
