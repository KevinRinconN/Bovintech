package com.bovintech.versionone.domain.cattle.usecases;

import com.bovintech.versionone.domain.cattle.model.constant.CattleErrorCatalog;
import com.bovintech.versionone.domain.cattle.model.dto.Cattle;
import com.bovintech.versionone.domain.cattle.model.exception.CattleNotFoundException;
import com.bovintech.versionone.domain.cattle.port.repository.ICattleRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CattleGetAllByIdUseCase {
    private final ICattleRepository cattleRepository;

    public List<Cattle> execute (List<Long> cattleIds){
        List<Cattle> cattleList = cattleRepository.findAllById(cattleIds);
        if (cattleList.size() != cattleIds.size()) {
            throw new CattleNotFoundException(CattleErrorCatalog.CATTLE_NOT_FOUND);
        }
        return cattleList;
    }
}
