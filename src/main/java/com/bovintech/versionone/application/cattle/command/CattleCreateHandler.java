package com.bovintech.versionone.application.cattle.command;

import com.bovintech.versionone.domain.cattle.model.dto.Cattle;
import com.bovintech.versionone.domain.cattle.model.dto.command.CattleCreateDTO;
import com.bovintech.versionone.domain.cattle.service.CattleCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CattleCreateHandler {
    private final CattleCreateService cattleCreateService;

    public Cattle execute (CattleCreateDTO cattleCreateDTO) {
        return this.cattleCreateService.execute(cattleCreateDTO);
    }
}
