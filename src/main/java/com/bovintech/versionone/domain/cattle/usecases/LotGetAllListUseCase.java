package com.bovintech.versionone.domain.cattle.usecases;

import com.bovintech.versionone.domain.cattle.model.dto.LotDto;
import com.bovintech.versionone.domain.cattle.port.repository.ILotRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RequiredArgsConstructor
public class LotGetAllListUseCase {
    private final ILotRespository iLotRespository;

    public List<LotDto> execute (List<Long> lots) {
        return iLotRespository.findAllById(lots);
    }
}
