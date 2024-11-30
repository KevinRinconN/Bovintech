package com.bovintech.versionone.application.cattle.query;

import com.bovintech.versionone.domain.cattle.model.dto.CattleShowByIdDto;
import com.bovintech.versionone.domain.cattle.model.dto.CattleShowDto;
import com.bovintech.versionone.domain.cattle.service.CattleGetByIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CattleGetByIdHandler {
    private final CattleGetByIdService cattleGetByIdService;

    public CattleShowByIdDto execute (Long id){
        return cattleGetByIdService.execute(id);
    }
}
