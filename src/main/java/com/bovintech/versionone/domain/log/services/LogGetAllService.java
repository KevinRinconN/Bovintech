package com.bovintech.versionone.domain.log.services;

import com.bovintech.versionone.domain.log.mapper.LogMapper;
import com.bovintech.versionone.domain.log.model.dto.LogGetDto;
import com.bovintech.versionone.domain.log.model.dto.LogSearchParams;
import com.bovintech.versionone.domain.log.useCases.LogGetAllUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public class LogGetAllService {
    private final LogGetAllUseCase logGetAllUseCase;

    public Page<LogGetDto> execute (String username, LogSearchParams LogSearchParams){
       return logGetAllUseCase.execute(username, LogSearchParams).map(LogMapper.INSTANCE::toShow);
    }
}
