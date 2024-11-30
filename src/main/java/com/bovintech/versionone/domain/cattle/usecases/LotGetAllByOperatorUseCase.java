package com.bovintech.versionone.domain.cattle.usecases;

import com.bovintech.versionone.domain.cattle.model.dto.LotDto;
import com.bovintech.versionone.domain.cattle.port.repository.ILotRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RequiredArgsConstructor
public class LotGetAllByOperatorUseCase {

    private final ILotRespository iLotRespository;

    public Page<LotDto> execute (String operator, Pageable pageable) {
        return iLotRespository.findAllCattleByOperator(operator, pageable);
    }
    public List<LotDto> execute (String operator) {
        return iLotRespository.findAllCattleByOperator(operator);
    }
}
