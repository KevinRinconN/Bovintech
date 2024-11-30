package com.bovintech.versionone.domain.event.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DayEventsDto {
    private String day; // Día del mes
    private List<EventToShowDto> events; // Lista de eventos para este día
}
