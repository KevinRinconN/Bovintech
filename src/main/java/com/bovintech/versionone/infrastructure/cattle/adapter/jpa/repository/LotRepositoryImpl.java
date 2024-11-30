package com.bovintech.versionone.infrastructure.cattle.adapter.jpa.repository;

import com.bovintech.versionone.domain.cattle.model.dto.LotDto;
import com.bovintech.versionone.domain.cattle.port.repository.ILotRespository;
import com.bovintech.versionone.infrastructure.cattle.adapter.jpa.ILotJpaRepository;
import com.bovintech.versionone.infrastructure.cattle.adapter.mapper.LotDboMapper;
import com.bovintech.versionone.infrastructure.cattle.adapter.model.entity.CattleLotEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class LotRepositoryImpl implements ILotRespository {

    private final ILotJpaRepository iLotJpaRepository;
    private final LotDboMapper lotDboMapper;

    @Override
    public Page<LotDto> findAll(String idOwner, Pageable pageable) {
        Page<CattleLotEntity> entities = iLotJpaRepository.findByOwnerUsername(idOwner, pageable);
        return entities.map(lotDboMapper::toDomain);
    }
    @Override
    public List<LotDto> findAll(String idOwner) {
        List<CattleLotEntity> entities = iLotJpaRepository.findByOwnerUsername(idOwner);
        return entities.stream().map(lotDboMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<LotDto> findAllById(List<Long> lots) {
        return iLotJpaRepository.findAllById(lots).stream().map(lotDboMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Page<LotDto> findAllCattleByOperator(String operator, Pageable pageable) {
        Page<CattleLotEntity> entities = iLotJpaRepository.findByOperatorUsername(operator, pageable);
        return entities.map(lotDboMapper::toDomain);
    }

    @Override
    public List<LotDto> findAllCattleByOperator(String operator) {
        List<CattleLotEntity> entities = iLotJpaRepository.findByOperatorUsername(operator);
        return entities.stream().map(lotDboMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public LotDto create(LotDto lot) {
        return lotDboMapper.toDomain(iLotJpaRepository.save(lotDboMapper.toDbo(lot)));
    }
}
