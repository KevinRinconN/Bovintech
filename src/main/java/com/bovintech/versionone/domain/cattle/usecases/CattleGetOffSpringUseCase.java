package com.bovintech.versionone.domain.cattle.usecases;

import com.bovintech.versionone.domain.cattle.model.dto.Cattle;
import com.bovintech.versionone.domain.cattle.port.repository.ICattleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RequiredArgsConstructor
public class CattleGetOffSpringUseCase {
    private final ICattleRepository iCattleRepository;

    public Page<Cattle> execute(Long id, Pageable pageable) {
        return iCattleRepository.findBySireIdOrDamId(id, id, pageable);
    }
}
