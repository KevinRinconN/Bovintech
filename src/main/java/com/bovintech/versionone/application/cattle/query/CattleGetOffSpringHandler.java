package com.bovintech.versionone.application.cattle.query;

import com.bovintech.versionone.domain.cattle.model.dto.CattleShowDto;
import com.bovintech.versionone.domain.cattle.service.CattleGetOffSpringService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CattleGetOffSpringHandler {
    private final CattleGetOffSpringService cattleGetOffSpringService;

    public Page<CattleShowDto> execute (Long id, Pageable pageable){
        return cattleGetOffSpringService.execute(id, pageable);
    }
}
