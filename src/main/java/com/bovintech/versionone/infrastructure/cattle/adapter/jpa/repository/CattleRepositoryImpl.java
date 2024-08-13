package com.bovintech.versionone.infrastructure.cattle.adapter.jpa.repository;

import com.bovintech.versionone.domain.cattle.model.dto.Cattle;
import com.bovintech.versionone.domain.cattle.model.dto.query.CattleSearchParams;
import com.bovintech.versionone.domain.cattle.port.repository.ICattleRepository;
import com.bovintech.versionone.infrastructure.cattle.adapter.jpa.ICattleJpaRepository;
import com.bovintech.versionone.infrastructure.cattle.adapter.jpa.specification.CattleSpecification;
import com.bovintech.versionone.infrastructure.cattle.adapter.mapper.CattleDboMapper;
import com.bovintech.versionone.infrastructure.cattle.adapter.model.entity.CattleEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CattleRepositoryImpl implements ICattleRepository {

    private final ICattleJpaRepository cattleJpaRepository;
    private final CattleDboMapper cattleDboMapper;
    @Override
    public Page<Cattle> findAllCattle(CattleSearchParams searchParams, Pageable pageable) {
        Specification<CattleEntity> specification = CattleSpecification
                .hasGender(searchParams.getGender())
                .and(CattleSpecification.hasBreed(searchParams.getBreed()));

        Page<CattleEntity> entityPage = cattleJpaRepository.findAll(specification,pageable);
        return entityPage.map(cattleDboMapper::toDomain);
    }

    @Override
    public Cattle create(Cattle cattle) {
        return cattleDboMapper.toDomain(cattleJpaRepository.save(cattleDboMapper.toDbo(cattle)));
    }

    @Override
    public Optional<Cattle> findById(Long id) {
        return cattleJpaRepository.findById(id).map(cattleDboMapper::toDomain);
    }
}
