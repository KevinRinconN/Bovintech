package com.bovintech.versionone.domain.cattle.service;

import com.bovintech.versionone.domain.cattle.mapper.CattleMapperDomain;
import com.bovintech.versionone.domain.cattle.model.dto.Cattle;
import com.bovintech.versionone.domain.cattle.model.dto.CattleShowDto;
import com.bovintech.versionone.domain.cattle.usecases.CattleGetOffSpringUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public class CattleGetOffSpringService {
    private final CattleGetOffSpringUseCase cattleGetOffSpringUseCase;

    public Page<CattleShowDto> execute (Long id, Pageable pageable){
        Page<Cattle> cattle = cattleGetOffSpringUseCase.execute(id,pageable);
        return cattle.map(CattleMapperDomain.INSTANCE::toCattleShow);
    }
}
