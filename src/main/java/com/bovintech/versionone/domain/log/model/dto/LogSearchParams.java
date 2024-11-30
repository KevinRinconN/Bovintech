package com.bovintech.versionone.domain.log.model.dto;

import com.bovintech.versionone.domain.log.model.constant.ActionType;
import com.bovintech.versionone.domain.log.model.constant.ModuleType;
import lombok.*;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class LogSearchParams {

    private LocalDateTime date;
    private List<ActionType> action;
    private List<ModuleType> module;
    private List<String> operators;
    private Pageable pageable;

    private boolean isOperator = false;

    public LogSearchParams(LocalDateTime date, List<ActionType> action, List<ModuleType> module, List<String> operators, Pageable pageable) {
        this.date = date;
        this.action = action;
        this.module = module;
        this.operators = operators;
        this.pageable = pageable;
    }
}
