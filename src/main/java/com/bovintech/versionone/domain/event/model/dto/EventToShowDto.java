package com.bovintech.versionone.domain.event.model.dto;

import com.bovintech.versionone.domain.cattle.model.dto.Cattle;
import com.bovintech.versionone.domain.cattle.model.dto.CattleWithOutRelationsDto;
import com.bovintech.versionone.domain.cattle.model.dto.LotDto;
import com.bovintech.versionone.domain.event.model.constant.EventStatus;
import com.bovintech.versionone.domain.event.model.constant.EventType;
import com.bovintech.versionone.infrastructure.auth.adapter.model.response.UserRest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventToShowDto {
    private Long id;
    private String name;
    private LocalDateTime eventDate;
    private EventType eventType;
    private EventStatus status;
    private List<UserRest> operators;
    private List<CattleWithOutRelationsDto> cattle;
    private List<LotDto> lots;
}
