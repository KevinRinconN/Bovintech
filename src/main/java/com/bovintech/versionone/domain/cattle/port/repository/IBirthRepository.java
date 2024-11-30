package com.bovintech.versionone.domain.cattle.port.repository;

import com.bovintech.versionone.domain.cattle.model.constant.BirthStatus;
import com.bovintech.versionone.domain.cattle.model.dto.Birth.BirthDto;

import java.util.List;
import java.util.Optional;

public interface IBirthRepository {
    BirthDto create (BirthDto birthDto);
    BirthDto save (BirthDto birthDto);
    Optional<BirthDto> findById (Long id);
    Optional<BirthDto> findByDamIdAndStatus(Long idDam, BirthStatus birthStatus);
    List<BirthDto> findByDamIdAndIsAbortion(Long idDam, boolean isAbortion);
    List<BirthDto> findByDamIdOrderByBirthDateDesc(Long damId);
}
