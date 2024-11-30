package com.bovintech.versionone.domain.cattle.port.repository;

import com.bovintech.versionone.domain.cattle.model.dto.Cattle;
import com.bovintech.versionone.domain.cattle.model.dto.query.CattleSearchParams;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICattleRepository {
    Page<Cattle> findAllCattle(CattleSearchParams cattleSearchParams, Pageable pageable);
    List<Cattle> findAllById(List<Long> ids);
    Cattle create(Cattle cattle);
    Optional<Cattle> findById(Long id);
    Page<Cattle> findBySireIdOrDamId(Long sireId, Long damId, Pageable pageable);
}
