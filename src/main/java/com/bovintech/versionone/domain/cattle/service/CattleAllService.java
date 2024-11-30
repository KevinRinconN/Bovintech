package com.bovintech.versionone.domain.cattle.service;

import com.bovintech.versionone.domain.cattle.mapper.CattleMapperDomain;
import com.bovintech.versionone.domain.cattle.model.dto.Cattle;
import com.bovintech.versionone.domain.cattle.model.dto.CattleShowDto;
import com.bovintech.versionone.domain.cattle.model.dto.query.CattleSearchParams;
import com.bovintech.versionone.domain.cattle.port.repository.ICattleRepository;
import com.bovintech.versionone.domain.cattle.usecases.CattleGetAllUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public class CattleAllService {

    private final CattleGetAllUseCase cattleGetAllUseCase;

    public Page<CattleShowDto> execute (CattleSearchParams cattleSearchParams, Pageable pageable) {
        Page<Cattle> cattle = cattleGetAllUseCase.execute(cattleSearchParams,pageable);
        return cattle.map(CattleMapperDomain.INSTANCE::toCattleShow);
    }
}
