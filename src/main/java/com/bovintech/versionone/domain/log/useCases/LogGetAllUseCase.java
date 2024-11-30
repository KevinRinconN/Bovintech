package com.bovintech.versionone.domain.log.useCases;

import com.bovintech.versionone.domain.log.model.dto.LogDto;
import com.bovintech.versionone.domain.log.model.dto.LogSearchParams;
import com.bovintech.versionone.domain.log.port.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public class LogGetAllUseCase {
    private final LogRepository logRepository;

    public Page<LogDto> execute (String username, LogSearchParams logSearchParams) {
        return  logRepository.findAllSearch(username, logSearchParams);
    }
}
