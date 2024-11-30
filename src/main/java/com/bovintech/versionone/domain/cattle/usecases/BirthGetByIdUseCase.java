package com.bovintech.versionone.domain.cattle.usecases;

import com.bovintech.versionone.domain.cattle.model.constant.CattleErrorCatalog;
import com.bovintech.versionone.domain.cattle.model.dto.Birth.BirthDto;
import com.bovintech.versionone.domain.cattle.model.exception.CattleNotFoundException;
import com.bovintech.versionone.domain.cattle.port.repository.IBirthRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BirthGetByIdUseCase {
    private final IBirthRepository iBirthRepository;

    public BirthDto execute (Long id){
        return iBirthRepository.findById(id).orElseThrow(()-> new CattleNotFoundException(CattleErrorCatalog.CATTLE_NO_ONGOING_BIRTH));
    }
}
