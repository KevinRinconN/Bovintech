package com.bovintech.versionone.domain.cattle.service;

import com.bovintech.versionone.domain.cattle.mapper.LotMapperDomain;
import com.bovintech.versionone.domain.cattle.model.dto.LotDto;
import com.bovintech.versionone.domain.cattle.model.dto.LotShowDto;
import com.bovintech.versionone.domain.cattle.usecases.LotGetAllUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class LotGetAllService {
    private final LotGetAllUseCase lotGetAllUseCase;

    public Page<LotShowDto> execute (String idOwner, Pageable pageable) {
        Page<LotDto> lots = lotGetAllUseCase.execute(idOwner, pageable);
        return lots.map(LotMapperDomain.INSTANCE::toLotShow);
    }

    public List<LotShowDto> execute (String idOwner) {
        List<LotDto> lots = lotGetAllUseCase.execute(idOwner);
        return lots.stream().map(LotMapperDomain.INSTANCE::toLotShow).collect(Collectors.toList());
    }
}
