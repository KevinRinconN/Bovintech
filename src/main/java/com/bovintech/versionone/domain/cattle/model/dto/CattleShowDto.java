package com.bovintech.versionone.domain.cattle.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Builder
@Getter
@Setter
public class CattleShowDto {

    private Long id;
    private Date dateOfBirth;
    private String distinctiveTrait;
    private String gender;
    private String breed;
    private String brand;
    private Integer lastWeight;
    private String lastWeightImage;
    private String stage;

}
