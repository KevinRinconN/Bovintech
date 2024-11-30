package com.bovintech.versionone.domain.cattle.service;

import com.bovintech.versionone.domain.cattle.mapper.LotMapperDomain;
import com.bovintech.versionone.domain.cattle.model.dto.LotDto;
import com.bovintech.versionone.domain.cattle.model.dto.LotShowDto;
import com.bovintech.versionone.domain.cattle.usecases.LotGetAllByOperatorUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class LotGetAllByOperatorService {
    private final LotGetAllByOperatorUseCase lotGetAllByOperatorUseCase;

    public Page<LotShowDto> execute (String idOwner, Pageable pageable) {
        Page<LotDto> lots = lotGetAllByOperatorUseCase.execute(idOwner, pageable);
        return lots.map(LotMapperDomain.INSTANCE::toLotShow);
    }

    public List<LotShowDto> execute (String idOwner) {
        List<LotDto> lots = lotGetAllByOperatorUseCase.execute(idOwner);
        return lots.stream().map(LotMapperDomain.INSTANCE::toLotShow).collect(Collectors.toList());
    }
}
