package com.bovintech.versionone.domain.cattle.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class LotCreateDto {

    private String name;
    private String description;
    private String operator;

}
