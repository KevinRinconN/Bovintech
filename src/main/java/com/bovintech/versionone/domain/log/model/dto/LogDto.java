package com.bovintech.versionone.domain.log.model.dto;

import com.bovintech.versionone.domain.auth.model.dto.User;
import com.bovintech.versionone.domain.log.model.constant.ActionType;
import com.bovintech.versionone.domain.log.model.constant.ModuleType;
import com.bovintech.versionone.infrastructure.auth.adapter.model.entity.UserEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class LogDto {
    private Long id;
    private LocalDateTime timestamp; // Fecha y hora del log
    private String logger;
    private ActionType action;
    private ModuleType module;
    private User user;
}
