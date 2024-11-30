package com.bovintech.versionone.domain.cattle.usecases;

import com.bovintech.versionone.domain.auth.model.dto.User;
import com.bovintech.versionone.domain.auth.port.repository.UserRepository;
import com.bovintech.versionone.domain.cattle.mapper.LotMapperDomain;
import com.bovintech.versionone.domain.cattle.model.dto.LotCreateDto;
import com.bovintech.versionone.domain.cattle.model.dto.LotDto;
import com.bovintech.versionone.domain.cattle.port.repository.ILotRespository;
import com.bovintech.versionone.infrastructure.auth.adapter.model.response.UserRest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LotCreateUseCase {
    private final ILotRespository iLotRespository;
    private final UserRepository userRepository;

    public LotDto execute (String idOwner, LotCreateDto lotCreateDto) {
        User owner = userRepository.getById(idOwner)
                .orElseThrow(() -> new IllegalArgumentException("Owner not found"));


        LotDto lotToSave = LotMapperDomain.INSTANCE.toDto(lotCreateDto);


        if (lotCreateDto.getOperator() != null) {
            User operator = userRepository.getById(lotCreateDto.getOperator())
                    .orElseThrow(() -> new IllegalArgumentException("Operator not found"));
            lotToSave.setOperator(LotMapperDomain.INSTANCE.toUseShow(operator));
        }


        lotToSave.setOwner(LotMapperDomain.INSTANCE.toUseShow(owner));

        return iLotRespository.create(lotToSave);
    }
}
