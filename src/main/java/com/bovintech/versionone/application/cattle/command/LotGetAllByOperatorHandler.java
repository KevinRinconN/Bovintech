package com.bovintech.versionone.application.cattle.command;

import com.bovintech.versionone.domain.cattle.model.dto.LotShowDto;
import com.bovintech.versionone.domain.cattle.service.LotGetAllByOperatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LotGetAllByOperatorHandler {
    private final LotGetAllByOperatorService lotGetAllByOperatorService;

    public Page<LotShowDto> execute (String idOwner, Pageable pageable){
        return  lotGetAllByOperatorService.execute(idOwner,pageable);
    }

    public List<LotShowDto> execute (String idOwner){
        return  lotGetAllByOperatorService.execute(idOwner);
    }
}
