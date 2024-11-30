package com.bovintech.versionone.application.cattle.command;

import com.bovintech.versionone.domain.cattle.model.dto.LotDto;
import com.bovintech.versionone.domain.cattle.model.dto.LotShowDto;
import com.bovintech.versionone.domain.cattle.service.LotGetAllService;
import com.bovintech.versionone.domain.cattle.usecases.LotGetAllUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LotGetAllHandler {
    private final LotGetAllService lotGetAllService;

    public Page<LotShowDto> execute (String idOwner, Pageable pageable){
        return  lotGetAllService.execute(idOwner,pageable);
    }

    public List<LotShowDto> execute (String idOwner){
        return  lotGetAllService.execute(idOwner);
    }
}
