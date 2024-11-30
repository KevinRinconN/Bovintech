package com.bovintech.versionone.domain.log.model.dto;

import com.bovintech.versionone.domain.log.model.constant.ActionType;
import com.bovintech.versionone.domain.log.model.constant.ModuleType;
import com.bovintech.versionone.infrastructure.auth.adapter.model.response.UserRest;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class LogGetDto {
    private Long id;
    private LocalDateTime timestamp;
    private String logger;
    private ActionType action;
    private ModuleType module;
    private UserRest user;
}
