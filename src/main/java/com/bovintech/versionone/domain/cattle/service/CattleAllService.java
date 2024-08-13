package com.bovintech.versionone.domain.cattle.service;

import com.bovintech.versionone.domain.cattle.model.dto.Cattle;
import com.bovintech.versionone.domain.cattle.model.dto.query.CattleSearchParams;
import com.bovintech.versionone.domain.cattle.port.repository.ICattleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public class CattleAllService {

    private final ICattleRepository cattleRepository;
    public Page<Cattle> execute (CattleSearchParams cattleSearchParams, Pageable pageable) {
        return cattleRepository.findAllCattle(cattleSearchParams,pageable);
    }
}
