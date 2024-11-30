package com.bovintech.versionone.domain.event.model.dto;

import com.bovintech.versionone.domain.event.model.constant.EventType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class EventGetSearchParamsDto {
    private String filter;
    private List<EventType> type;
    private List<String> operators;
    private List<Long> lots;
    private boolean isOperator = false;

    public EventGetSearchParamsDto(String filter, List<EventType> type, List<String> operators, List<Long> lots) {
        this.filter = filter;
        this.type = type;
        this.operators = operators;
        this.lots = lots;
    }
}
