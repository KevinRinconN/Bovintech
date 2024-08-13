package com.bovintech.versionone.application.cattle.query;

import com.bovintech.versionone.domain.cattle.model.dto.Cattle;
import com.bovintech.versionone.domain.cattle.model.dto.query.CattleSearchParams;
import com.bovintech.versionone.domain.cattle.service.CattleAllService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CattleAllHandler {

    private final CattleAllService cattleAllService;

    public Page<Cattle> execute (CattleSearchParams cattleSearchParams, Pageable pageable){
        return cattleAllService.execute(cattleSearchParams,pageable);
    }
}
