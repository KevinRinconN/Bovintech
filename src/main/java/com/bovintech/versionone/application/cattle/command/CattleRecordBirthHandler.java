package com.bovintech.versionone.application.cattle.command;

import com.bovintech.versionone.domain.cattle.model.dto.Birth.BirthDto;
import com.bovintech.versionone.domain.cattle.model.dto.CattleBirthRecord;
import com.bovintech.versionone.domain.cattle.usecases.CattleRegisterBirthUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CattleRecordBirthHandler {
    private final CattleRegisterBirthUseCase cattleRegisterBirthUseCase;

    public BirthDto execute (Long id, CattleBirthRecord cattleBirthRecord){
        return cattleRegisterBirthUseCase.execute(id, cattleBirthRecord);
    }
}
