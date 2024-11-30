package com.bovintech.versionone.domain.cattle.service;

import com.bovintech.versionone.domain.cattle.mapper.CattleMapperDomain;
import com.bovintech.versionone.domain.cattle.model.dto.CattleShowByIdDto;
import com.bovintech.versionone.domain.cattle.model.dto.CattleShowDto;
import com.bovintech.versionone.domain.cattle.usecases.CattleGetByIdUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CattleGetByIdService {
    private final CattleGetByIdUseCase cattleGetByIdUseCase;

    public CattleShowByIdDto execute (Long id){
        return CattleMapperDomain.INSTANCE.toCattleShowById(cattleGetByIdUseCase.execute(id));
    }
}
