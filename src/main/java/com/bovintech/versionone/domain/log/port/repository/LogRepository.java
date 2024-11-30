package com.bovintech.versionone.domain.log.port.repository;

import com.bovintech.versionone.domain.log.model.dto.LogDto;
import com.bovintech.versionone.domain.log.model.dto.LogSearchParams;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LogRepository {
    LogDto save (LogDto logDto);
    Page<LogDto> findAllSearch (String username, LogSearchParams logSearchParams);
}
