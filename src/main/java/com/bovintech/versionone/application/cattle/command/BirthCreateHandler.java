package com.bovintech.versionone.application.cattle.command;

import com.bovintech.versionone.domain.cattle.model.dto.Birth.BirthCreateDto;
import com.bovintech.versionone.domain.cattle.model.dto.Birth.BirthDto;
import com.bovintech.versionone.domain.cattle.usecases.BirthCreateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BirthCreateHandler {
    private final BirthCreateUseCase birthCreateUseCase;

    public BirthDto execute (Long idDamn, BirthCreateDto birthCreateDto){
        return birthCreateUseCase.execute(idDamn, birthCreateDto);
    }
}
