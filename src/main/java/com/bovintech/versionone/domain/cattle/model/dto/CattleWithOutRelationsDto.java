package com.bovintech.versionone.domain.cattle.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Builder
@Getter
@Setter
public class CattleWithOutRelationsDto {
    private Long id;
    private LocalDate dateOfBirth;
    private String distinctiveTrait;
    private String gender;
    private String breed;
    private String brand;
    private String lastWeightImage;
}
