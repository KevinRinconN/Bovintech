package com.bovintech.versionone.application.cattle.query;

import com.bovintech.versionone.domain.cattle.model.dto.Birth.BirthDto;
import com.bovintech.versionone.domain.cattle.model.dto.Birth.BirthRecords;
import com.bovintech.versionone.domain.cattle.usecases.CattleGetOngoingBirthUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CattleGetOngoingBirthHandler {
    private final CattleGetOngoingBirthUseCase cattleGetOngoingBirthUseCase;

    public BirthRecords execute (Long idDam){
        return cattleGetOngoingBirthUseCase.execute(idDam);
    }
}
