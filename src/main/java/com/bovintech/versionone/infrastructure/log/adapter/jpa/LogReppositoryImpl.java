package com.bovintech.versionone.infrastructure.log.adapter.jpa;

import com.bovintech.versionone.domain.log.model.dto.LogDto;
import com.bovintech.versionone.domain.log.model.dto.LogSearchParams;
import com.bovintech.versionone.domain.log.port.repository.LogRepository;
import com.bovintech.versionone.infrastructure.log.adapter.mapper.LogDboMapper;
import com.bovintech.versionone.infrastructure.log.adapter.model.LogEntity;
import com.bovintech.versionone.infrastructure.log.adapter.specificacion.LogSpecificacions;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LogReppositoryImpl implements LogRepository {

    private final ILogJpaRepository iLogJpaRepository;
    private final LogDboMapper logDboMapper;

    @Override
    public LogDto save(LogDto logDto) {
        return logDboMapper.toDomain(iLogJpaRepository.save(logDboMapper.toDbo(logDto)));
    }

    @Override
    public Page<LogDto> findAllSearch(String username, LogSearchParams logSearchParams) {
//        Specification<LogEntity> specification = Specification.where(logSearchParams.isOperator() ? LogSpecificacions.LogsByOperator(username) : LogSpecificacions.LogsByOwner(username))
        Specification<LogEntity> specification = Specification.where(LogSpecificacions.hasOperators(logSearchParams.getOperators()))
        .and(LogSpecificacions.hasAction(logSearchParams.getAction()))
                .and(LogSpecificacions.hasModule(logSearchParams.getModule()))
                .and(LogSpecificacions.hasDate(logSearchParams.getDate()));

        return iLogJpaRepository.findAll(specification, logSearchParams.getPageable()).map(logDboMapper::toDomain);
    }
}
