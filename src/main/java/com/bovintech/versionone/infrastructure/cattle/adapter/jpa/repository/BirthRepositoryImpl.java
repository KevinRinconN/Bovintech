package com.bovintech.versionone.infrastructure.cattle.adapter.jpa.repository;

import com.bovintech.versionone.domain.cattle.model.constant.BirthStatus;
import com.bovintech.versionone.domain.cattle.model.dto.Birth.BirthDto;
import com.bovintech.versionone.domain.cattle.port.repository.IBirthRepository;
import com.bovintech.versionone.infrastructure.cattle.adapter.jpa.IBirthJpaRepository;
import com.bovintech.versionone.infrastructure.cattle.adapter.mapper.BirthDboMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BirthRepositoryImpl implements IBirthRepository {
    private final IBirthJpaRepository iBirthJpaRepository;
    private final BirthDboMapper birthDboMapper;
    @Override
    public BirthDto create(BirthDto birthDto) {
        return birthDboMapper.toDomain(iBirthJpaRepository.save(birthDboMapper.toDbo(birthDto)));
    }

    @Override
    public BirthDto save(BirthDto birthDto) {
        return birthDboMapper.toDomain(iBirthJpaRepository.save(birthDboMapper.toDbo(birthDto)));
    }

    @Override
    public Optional<BirthDto> findById(Long id) {
        return iBirthJpaRepository.findById(id).map(birthDboMapper::toDomain);
    }

    @Override
    public Optional<BirthDto> findByDamIdAndStatus(Long idDam, BirthStatus birthStatus) {
        return iBirthJpaRepository.findByDamIdAndStatus(idDam, birthStatus).map(birthDboMapper::toDomain);
    }

    @Override
    public List<BirthDto> findByDamIdAndIsAbortion(Long idDam, boolean isAbortion) {
        return iBirthJpaRepository.findByDamIdAndIsAbortion(idDam, isAbortion)
                .stream()
                .map(birthDboMapper::toDomain)
                .toList();
    }

    @Override
    public List<BirthDto> findByDamIdOrderByBirthDateDesc(Long damId) {
        return iBirthJpaRepository.findByDamIdOrderByBirthDateDesc(damId)
                .stream()
                .map(birthDboMapper::toDomain)
                .toList();
    }
}
