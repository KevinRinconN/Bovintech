package com.bovintech.versionone.domain.event.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MonthlyEventsDTO {
    private String month;
    private String year;
    private List<DayEventsDto> dayEvents;
}
