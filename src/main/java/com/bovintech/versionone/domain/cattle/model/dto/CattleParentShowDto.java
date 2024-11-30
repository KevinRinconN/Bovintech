package com.bovintech.versionone.domain.cattle.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Builder
@Getter
@Setter
public class CattleParentShowDto {
    private Long id;
    private String gender;
    private String breed;
    private String brand;
    private String lastWeightImage;
}