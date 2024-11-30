package com.bovintech.versionone.domain.cattle.model.dto;

import com.bovintech.versionone.domain.auth.model.dto.User;
import com.bovintech.versionone.infrastructure.auth.adapter.model.response.UserRest;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class LotDto {
    private Long id;
    private String name;
    private String description;

    private UserRest owner;

    private UserRest operator;

    private List<CattleWithOutRelationsDto> cattle;
}
