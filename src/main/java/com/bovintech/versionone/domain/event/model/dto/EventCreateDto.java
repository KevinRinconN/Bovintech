package com.bovintech.versionone.domain.event.model.dto;

import com.bovintech.versionone.domain.event.model.constant.EventStatus;
import com.bovintech.versionone.domain.event.model.constant.EventType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class EventCreateDto {

    @NotEmpty(message = "name requerido")
    @Size(min = 5, max = 100)
    private String name;

    @NotNull(message = "date_event requerido")
    @JsonProperty("date_event")
    private LocalDateTime eventDate;

    @NotNull
    private EventType eventType;

    private List<Long> cattleIds; // IDs de bovinos asociados al evento
    private List<String> operatorUsernames; // Usernames de operadores
    private List<Long> lotsId;

    public EventCreateDto(String name, LocalDateTime eventDate, EventType eventType, List<Long> cattleIds, List<String> operatorUsernames, List<Long> lotsId) {
        this.name = name;
        this.eventDate = eventDate;
        this.eventType = eventType;
        this.cattleIds = cattleIds;
        this.operatorUsernames = operatorUsernames;
        this.lotsId = lotsId;
    }

    private boolean isOperator = false;
}
