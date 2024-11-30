package com.bovintech.versionone.domain.cattle.model.dto;

import com.bovintech.versionone.infrastructure.auth.adapter.model.response.UserRest;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class LotShowDto {
    private Long id;
    private String name;
    private String description;

    private UserRest operator;

    private Integer numberCattle;
}
